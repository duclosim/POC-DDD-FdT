package fr.excilys.domain.fdt;

import java.util.Optional;

/**
 * Created by sduclos on 21/10/16.
 */
public class CodeActivite {
    private Long idCodeActivite;
    private String code;
    private Optional<Periode> periodeValidite;

    private CodeActivite(Long idCodeActivite, String code, Optional<Periode> periodeValidite) {
        this.idCodeActivite = idCodeActivite;
        this.code = code;
        this.periodeValidite = periodeValidite;
    }

    public Long getIdCodeActivite() {
        return idCodeActivite;
    }

    public String getCode() {
        return code;
    }

    public Optional<Periode> getPeriodeValidite() {
        return periodeValidite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeActivite that = (CodeActivite) o;

        return idCodeActivite != null ? idCodeActivite.equals(that.idCodeActivite) : that.idCodeActivite == null;

    }

    @Override
    public int hashCode() {
        return idCodeActivite != null ? idCodeActivite.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CodeActivite{" +
                "idCodeActivite=" + idCodeActivite +
                ", code='" + code + '\'' +
                ", periodeValidite=" + periodeValidite +
                '}';
    }

    public static class Builder {
        private Long idCodeActivite;
        private String code;
        private Optional<Periode> periodeValidite = Optional.empty();

        public Builder withId(Long idCodeActivite) {
            this.idCodeActivite = idCodeActivite;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withPeriodeValidite(Optional<Periode> periodeValidite) {
            this.periodeValidite = periodeValidite;
            return this;
        }

        public CodeActivite build() {
            return new CodeActivite(idCodeActivite, code, periodeValidite);
        }
    }
}
