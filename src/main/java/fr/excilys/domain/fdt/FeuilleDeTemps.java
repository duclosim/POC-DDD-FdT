package fr.excilys.domain.fdt;

import fr.excilys.service.FeuilleDeTempsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sduclos on 21/10/16.
 */
public class FeuilleDeTemps {
    private Long id;
    private Mois mois;
    private List<Activite> activites;
    private StatutFdt statut;

    private FeuilleDeTempsService feuilleDeTempsService = new FeuilleDeTempsService();

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

    public List<Activite> getActivites() {
        return new ArrayList<>(activites);
    }

    public StatutFdt getStatut() {
        return statut;
    }

    public void ajouterActivite(Activite activite) {
        activites.add(activite);
        feuilleDeTempsService.ajouterActivite(this, activite);
    }

    public void passerAuProchainStatut() {
        statut = statut.prochaineTransition();
    }

    public void revenirAuStatutPrecedent() {
        statut = statut.transitionPrecedente();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeuilleDeTemps that = (FeuilleDeTemps) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FeuilleDeTemps{" +
                "id=" + id +
                ", mois=" + mois +
                ", activites=" + activites +
                ", statut=" + statut +
                ", feuilleDeTempsService=" + feuilleDeTempsService +
                '}';
    }

    public static class Builder {
        private Long id;
        private Mois mois;
        private List<Activite> activites = new ArrayList<>();
        private StatutFdt statutFdt = StatutFdt.BROUILLON;

        public FeuilleDeTemps build() {
            return new FeuilleDeTemps(id, mois, activites, statutFdt);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withMois(Mois mois) {
            this.mois = mois;
            return this;
        }

        public Builder withActivites(List<Activite> activites) {
            this.activites = activites;
            return this;
        }

        public Builder withStatutFdt(StatutFdt statutFdt) {
            this.statutFdt = statutFdt;
            return this;
        }
    }
}
