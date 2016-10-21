package fr.excilys.domain.fdt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTemps {
    private Long id;
    private Mois mois;
    private List<Activite> activites;
    private StatutFdt statut;

    private FeuilleDeTemps(Long id, Mois mois, List<Activite> activites, StatutFdt statutFdt) {
        this.id = id;
        this.mois = mois;
        this.activites = activites;
        this.statut = statutFdt;
    }

    public Long getId() {
        return id;
    }

    public Mois getMois() {
        return mois;
    }

    public Collection<Activite> getActivites() {
        return new ArrayList<>(activites);
    }

    public StatutFdt getStatut() {
        return statut;
    }

    public void ajouterActivite(Activite activite) {
        activites.add(activite);
    }

    public void passerAuProchainStatut() {
        statut = statut.prochaineTransition();
    }

    public void revenirAuStatutPrecedent() {
        statut = statut.transitionPrecedente();
    }

    public static class FeuilleDeTempsBuilder {
        private Long id;
        private Mois mois;
        private List<Activite> activites = new ArrayList<>();
        private StatutFdt statutFdt = StatutFdt.BROUILLON;

        public FeuilleDeTemps build() {
            return new FeuilleDeTemps(id, mois, activites, statutFdt);
        }

        public FeuilleDeTempsBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public FeuilleDeTempsBuilder withMois(Mois mois) {
            this.mois = mois;
            return this;
        }

        public FeuilleDeTempsBuilder withActivites(List<Activite> activites) {
            this.activites = activites;
            return this;
        }

        public FeuilleDeTempsBuilder withStatutFdt(StatutFdt statutFdt) {
            this.statutFdt = statutFdt;
            return this;
        }
    }
}
