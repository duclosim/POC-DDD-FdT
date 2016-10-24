package fr.excilys.infrastructure;

import fr.excilys.service.dto.FeuilleDeTempsInfraDTO;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTempsRepository {

    public FeuilleDeTempsInfraDTO getById(Long id) {
        // Récupération via les outils de persistance
        return new FeuilleDeTempsInfraDTO();
    }

    public void save(FeuilleDeTempsInfraDTO dto) {
        // Enregistrement du dto via les outils de persistence
    }
}
