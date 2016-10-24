package fr.excilys.service.mapper;

import fr.excilys.domain.fdt.Mois;

import java.time.LocalDate;

/**
 * Created by sduclos on 21/10/16.
 */
public class MoisMapper {

    public LocalDate toDTO(Mois mois) {
        return LocalDate.of(mois.annee, mois.mois, 1);
    }

    public Mois fromDTO(LocalDate dto) {
        return new Mois(dto.getYear(), dto.getMonthValue());
    }
}
