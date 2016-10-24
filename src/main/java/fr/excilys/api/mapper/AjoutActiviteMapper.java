package fr.excilys.api.mapper;

import fr.excilys.api.dto.AjoutActiviteDto;
import fr.excilys.domain.fdt.Activite;
import fr.excilys.domain.fdt.Periode;
import fr.excilys.infrastructure.CodeActiviteRepository;

/**
 * Created by sduclos on 21/10/16.
 */
public class AjoutActiviteMapper {
    private CodeActiviteRepository codeActiviteRepository = new CodeActiviteRepository();

    public Activite fromDto(AjoutActiviteDto dto) {
        return new Activite(codeActiviteRepository.getById(dto.idCodeActivite),
                new Periode(dto.debutPeriode,
                        dto.finPeriode
                )
        );
    }
}
