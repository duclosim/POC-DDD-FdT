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
}
