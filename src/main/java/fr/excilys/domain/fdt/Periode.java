package fr.excilys.domain.fdt;

import java.time.LocalDateTime;

/**
 * Created by sduclos on 21/10/16.
 */
public class Periode {
    public final LocalDateTime dateDebut;
    public final LocalDateTime dateFin;

    public Periode(LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Periode periode = (Periode) o;

        if (dateDebut != null ? !dateDebut.equals(periode.dateDebut) : periode.dateDebut != null) return false;
        return dateFin != null ? dateFin.equals(periode.dateFin) : periode.dateFin == null;

    }

    @Override
    public int hashCode() {
        int result = dateDebut != null ? dateDebut.hashCode() : 0;
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Periode{" +
                "dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
