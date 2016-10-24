package fr.excilys.domain.fdt;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sduclos on 24/10/16.
 */
public class StatutFdtTest {

    @Test
    public void prochaineTransition_doit_retourner_le_même_statut_si_on_est_déjà_au_dernier() {
        // GIVEN
        StatutFdt statutFdt = StatutFdt.values()[StatutFdt.values().length - 1];
        // WHEN
        StatutFdt result = statutFdt.prochaineTransition();
        // THEN
        assertThat(result).isEqualTo(statutFdt);
    }

    @Test
    public void prochaineTransition_doit_retourner_le_statut_suivant_si_on_est_pas_déjà_au_dernier() {
        // GIVEN
        Random random = new Random();
        Integer randOrdre = random.nextInt(StatutFdt.values().length);
        StatutFdt statutFdt = StatutFdt.values()[randOrdre];
        // WHEN
        StatutFdt result = statutFdt.prochaineTransition();
        // THEN
        assertThat(result).isEqualTo(StatutFdt.values()[randOrdre + 1]);
    }

    @Test
    public void transitionPrécédente_doit_retourner_le_même_statut_si_on_est_déjà_au_premier() {
        // GIVEN
        StatutFdt statutFdt = StatutFdt.values()[0];
        // WHEN
        StatutFdt result = statutFdt.transitionPrecedente();
        // THEN
        assertThat(result).isEqualTo(statutFdt);
    }

    @Test
    public void transitionPrécédente_doit_retourner_le_statut_précédent_si_on_est_pas_déjà_au_premier() {
        // GIVEN
        Random random = new Random();
        Integer randOrdre = random.nextInt(StatutFdt.values().length - 1) + 1;
        StatutFdt statutFdt = StatutFdt.values()[randOrdre];
        // WHEN
        StatutFdt result = statutFdt.transitionPrecedente();
        // THEN
        assertThat(result).isEqualTo(StatutFdt.values()[randOrdre - 1]);
    }
}
