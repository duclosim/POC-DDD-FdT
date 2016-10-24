package fr.excilys.domain.fdt;

/**
 * Created by sduclos on 21/10/16.
 */
public class Activite {
    public final CodeActivite codeActivite;
    public final Periode periode;

    public Activite(CodeActivite codeActivite, Periode periode) {
        this.codeActivite = codeActivite;
        this.periode = periode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activite activite = (Activite) o;

        if (codeActivite != null ? !codeActivite.equals(activite.codeActivite) : activite.codeActivite != null)
            return false;
        return periode != null ? periode.equals(activite.periode) : activite.periode == null;

    }

    @Override
    public int hashCode() {
        int result = codeActivite != null ? codeActivite.hashCode() : 0;
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Activite{" +
                "codeActivite=" + codeActivite +
                ", periode=" + periode +
                '}';
    }
}
