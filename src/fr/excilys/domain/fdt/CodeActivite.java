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

    public static class CodeActiviteBuilder {
        private Long idCodeActivite;
        private String code;
        private Optional<Periode> periodeValidite = Optional.empty();

        public CodeActiviteBuilder withId(Long idCodeActivite) {
            this.idCodeActivite = idCodeActivite;
            return this;
        }

        public CodeActiviteBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public CodeActiviteBuilder withPeriodeValidite(Optional<Periode> periodeValidite) {
            this.periodeValidite = periodeValidite;
            return this;
        }

        public CodeActivite build() {
            return new CodeActivite(idCodeActivite, code, periodeValidite);
        }
    }
}
