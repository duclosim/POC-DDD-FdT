package fr.excilys.service;

import fr.excilys.domain.fdt.Activite;
import fr.excilys.domain.fdt.FeuilleDeTemps;
import fr.excilys.infrastructure.FeuilleDeTempsRepository;
import fr.excilys.service.dto.ActiviteInfraDTO;
import fr.excilys.service.dto.FeuilleDeTempsInfraDTO;
import fr.excilys.service.mapper.ActiviteMapper;
import fr.excilys.service.mapper.FeuilleDeTempsMapper;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTempsService {

    private ActiviteMapper activiteMapper = new ActiviteMapper();
    private FeuilleDeTempsMapper feuilleDeTempsMapper = new FeuilleDeTempsMapper();

    private FeuilleDeTempsRepository feuilleDeTempsRepository = new FeuilleDeTempsRepository();

    public FeuilleDeTemps getById(Long idFdt) {
        return feuilleDeTempsMapper.fromDTO(feuilleDeTempsRepository.getById(idFdt));
    }

    public void ajouterActivite(FeuilleDeTemps feuilleDeTemps, Activite activite) {
        ActiviteInfraDTO activiteInfraDTO = activiteMapper.toDTO(activite);
        FeuilleDeTempsInfraDTO feuilleDeTempsInfraDTO = feuilleDeTempsMapper.toDTO(feuilleDeTemps);
        feuilleDeTempsRepository.save(feuilleDeTempsInfraDTO);
    }
}
