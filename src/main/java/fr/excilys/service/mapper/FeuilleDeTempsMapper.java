package fr.excilys.service.mapper;

import fr.excilys.domain.fdt.FeuilleDeTemps;
import fr.excilys.service.dto.FeuilleDeTempsInfraDTO;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTempsMapper {
    private MoisMapper moisMapper = new MoisMapper();
    private ActiviteMapper activiteMapper = new ActiviteMapper();

    public FeuilleDeTemps fromDTO(FeuilleDeTempsInfraDTO dto) {
        return new FeuilleDeTemps.Builder()
                .withId(dto.id)
                .withMois(moisMapper.fromDTO(dto.mois))
                .withActivites(activiteMapper.fromDTOs(dto.activites))
                .withStatutFdt(dto.statutFdt)
                .build();
    }

    public FeuilleDeTempsInfraDTO toDTO(FeuilleDeTemps feuilleDeTemps) {
        FeuilleDeTempsInfraDTO dto = new FeuilleDeTempsInfraDTO();
        dto.id = feuilleDeTemps.getId();
        dto.mois = moisMapper.toDTO(feuilleDeTemps.getMois());
        dto.activites = activiteMapper.toDTOs(feuilleDeTemps.getActivites());
        dto.statutFdt = feuilleDeTemps.getStatut();
        return dto;
    }
}
