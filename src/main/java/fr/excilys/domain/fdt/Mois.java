package fr.excilys.domain.fdt;

/**
 * Created by sduclos on 21/10/16.
 */
public class Mois {
    public final int annee;
    public final int mois;

    public Mois(int annee, int mois) {
        this.annee = annee;
        this.mois = mois;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mois mois1 = (Mois) o;

        if (annee != mois1.annee) return false;
        return mois == mois1.mois;

    }

    @Override
    public int hashCode() {
        int result = annee;
        result = 31 * result + mois;
        return result;
    }

    @Override
    public String toString() {
        return "Mois{" +
                "annee=" + annee +
                ", mois=" + mois +
                '}';
    }
}
