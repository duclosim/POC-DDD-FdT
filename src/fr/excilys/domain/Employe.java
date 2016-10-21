package fr.excilys.domain;

import fr.excilys.domain.fdt.CodeActivite;
import fr.excilys.domain.fdt.FeuilleDeTemps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sduclos on 21/10/16.
 */
public class Employe {
    private Long id;
    private String matricule;
    private List<FeuilleDeTemps> feuillesDeTemps;
    private Set<CodeActivite> codesActivite;

    private Employe(Long id, String matricule, List<FeuilleDeTemps> feuillesDeTemps, Set<CodeActivite> codesActivite) {
        this.id = id;
        this.matricule = matricule;
        this.feuillesDeTemps = feuillesDeTemps;
        this.codesActivite = codesActivite;
    }

    public Long getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public Collection<FeuilleDeTemps> getFeuillesDeTemps() {
        return new ArrayList<>(feuillesDeTemps);
    }

    public Set<CodeActivite> getCodesActivite() {
        return new TreeSet<>(codesActivite);
    }

    public static class EmployeBuilder {
        private Long id;
        private String matricule;
        private List<FeuilleDeTemps> feuillesDeTemps = new ArrayList<>();
        private Set<CodeActivite> codesActivite = new TreeSet<>();

        public Employe build() {
            return new Employe(id, matricule, feuillesDeTemps, codesActivite);
        }

        public EmployeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeBuilder withMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public EmployeBuilder withFeuillesDeTemps(List<FeuilleDeTemps> feuillesDeTemps) {
            this.feuillesDeTemps = feuillesDeTemps;
            return this;
        }

        public EmployeBuilder withCodesActivite(Set<CodeActivite> codesActivite) {
            this.codesActivite = codesActivite;
            return this;
        }
    }
}
