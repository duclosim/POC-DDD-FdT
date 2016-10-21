package fr.excilys.service.mapper;

import fr.excilys.domain.fdt.CodeActivite;
import fr.excilys.domain.fdt.Periode;
import fr.excilys.service.dto.CodeActiviteInfraDTO;

import java.util.Optional;

/**
 * Created by sduclos on 21/10/16.
 */
public class CodeActiviteMapper {

    public CodeActivite fromDTO(CodeActiviteInfraDTO dto) {
        Periode periode = dto.periode == null ? null : new Periode(dto.periode.dateDebut, dto.periode.dateFin);
        return new CodeActivite.Builder()
                .withId(dto.id)
                .withCode(dto.code)
                .withPeriodeValidite(Optional.ofNullable(periode))
                .build();
    }

    public CodeActiviteInfraDTO toDTO(CodeActivite codeActivite) {
        CodeActiviteInfraDTO dto = new CodeActiviteInfraDTO();
        dto.id = codeActivite.getIdCodeActivite();
        dto.code = codeActivite.getCode();
        dto.periode = codeActivite.getPeriodeValidite().orElse(null);
        return dto;
    }
}
