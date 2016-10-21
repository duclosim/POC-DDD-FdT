package fr.excilys.infrastructure;

import fr.excilys.domain.fdt.CodeActivite;

/**
 * Created by sduclos on 21/10/16.
 */
public class CodeActiviteRepository {

    public CodeActivite getById(Long id) {
        // Fait appel aux outils de persistance pour remonter le CodeActivite
        return new CodeActivite.Builder().build();
    }
}
