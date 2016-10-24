package fr.excilys.domain.fdt;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sduclos on 24/10/16.
 */
public class FeuilleDeTempsTest {

    @Test
    public void getActivites_doit_retourner_une_nouvelle_liste() {
        // GIVEN
        Long idCodeActivite = 2358L;
        CodeActivite codeActivite = mock(CodeActivite.class);
        when(codeActivite.getIdCodeActivite()).thenReturn(idCodeActivite);

        Activite activitePrec = new Activite(codeActivite, mock(Periode.class));
        List<Activite> activites = new ArrayList<>();
        activites.add(activitePrec);

        FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps.Builder().withActivites(activites).build();
        // WHEN
        List<Activite> result = feuilleDeTemps.getActivites();
        // THEN
        result.remove(0);
        assertThat(result).isNotEqualTo(activites);
    }

    @Test
    public void ajouterActivite_doit_ajouter_une_activite_à_la_liste() {
        // GIVEN
        CodeActivite codeActivite = new CodeActivite.Builder()
                .withId(2358L)
                .withCode("INT_SRH_CMTE")
                .build();
        Activite activite = new Activite(codeActivite, new Periode(LocalDateTime.now(), LocalDateTime.now()));
        FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps.Builder()
                .withId(214558L)
                .withMois(new Mois(2016, 10))
                .build();
        // WHEN
        feuilleDeTemps.ajouterActivite(activite);
        // THEN
        assertThat(feuilleDeTemps.getActivites()).contains(activite);
    }

    @Test
    public void passerAuProchainStatut_doit_changer_le_statut_avec_le_résultat_de_l_appel_à_la_méthode_du_statut() {
        // GIVEN
        FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps.Builder()
                .build();
        // WHEN
        feuilleDeTemps.passerAuProchainStatut();
        // THEN
        assertThat(feuilleDeTemps.getStatut()).isEqualTo(StatutFdt.VALIDEE_CONSULTANT);
    }

    @Test
    public void revenirAuStatutPrécédent_doit_changer_le_statut_avec_le_résultat_de_l_appel_à_la_méthode_du_statut() {
        // GIVEN
        FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps.Builder()
                .withStatutFdt(StatutFdt.VALIDEE_ADMINISTRATIF)
                .build();
        // WHEN
        feuilleDeTemps.revenirAuStatutPrecedent();
        // THEN
        assertThat(feuilleDeTemps.getStatut()).isEqualTo(StatutFdt.VALIDEE_CONSULTANT);
    }
}
