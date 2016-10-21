package fr.excilys.service.mapper;

import fr.excilys.domain.fdt.Activite;
import fr.excilys.service.dto.ActiviteInfraDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sduclos on 21/10/16.
 */
public class ActiviteMapper {
    private CodeActiviteMapper codeActiviteMapper = new CodeActiviteMapper();

    public List<Activite> fromDTOs(List<ActiviteInfraDTO> dtos) {
        return dtos.stream()
                .map(this::fromDTO)
                .collect(Collectors.toList());
    }

    public Activite fromDTO(ActiviteInfraDTO dto) {
        return new Activite(
                codeActiviteMapper.fromDTO(dto.codeActivite), dto.periode);
    }

    public List<ActiviteInfraDTO> toDTOs(List<Activite> activites) {
        return activites.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ActiviteInfraDTO toDTO(Activite activite) {
        ActiviteInfraDTO dto = new ActiviteInfraDTO();
        dto.codeActivite = codeActiviteMapper.toDTO(activite.codeActivite);
        dto.periode = activite.periode;
        return dto;
    }
}
