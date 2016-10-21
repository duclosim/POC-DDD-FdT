package fr.excilys.api.controller;

import fr.excilys.api.dto.AjoutActiviteDto;
import fr.excilys.api.mapper.AjoutActiviteMapper;
import fr.excilys.domain.fdt.Activite;
import fr.excilys.domain.fdt.FeuilleDeTemps;
import fr.excilys.service.FeuilleDeTempsService;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTempsController {

    private AjoutActiviteMapper ajoutActiviteMapper = new AjoutActiviteMapper();
    private FeuilleDeTempsService service = new FeuilleDeTempsService();

    // Peut être appelé par quelque chose genre web service
    public void ajouterActivite(Long idFdt, AjoutActiviteDto activiteDto) {
        FeuilleDeTemps feuilleDeTemps = service.getById(idFdt);
        Activite activite = ajoutActiviteMapper.fromDto(activiteDto);
        feuilleDeTemps.ajouterActivite(activite);
    }
}
