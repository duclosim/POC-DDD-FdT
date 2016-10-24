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
}
