package fr.excilys.service.dto;

import fr.excilys.domain.fdt.StatutFdt;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTempsInfraDTO {
    public Long id;
    public LocalDate mois;
    public List<ActiviteInfraDTO> activites;
    public StatutFdt statutFdt;
}
