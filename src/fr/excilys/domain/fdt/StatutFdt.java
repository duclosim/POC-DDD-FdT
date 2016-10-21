package fr.excilys.domain.fdt;

/**
 * Created by sduclos on 21/10/16.
 */
public enum StatutFdt {
    BROUILLON(0, "Brouillon"),
    VALIDEE_CONSULTANT(1, "Validée par le consultant"),
    VALIDEE_ADMINISTRATIF(2, "Validée par le service administratif");

    public final int ordre;
    public final String code;

    StatutFdt(int ordre, String code) {
        this.ordre = ordre;
        this.code = code;
    }

    public StatutFdt prochaineTransition() {
        int ordreProchainStatut = Integer.min((ordre + 1) , StatutFdt.values().length);
        return StatutFdt.values()[ordreProchainStatut];
    }

    public StatutFdt transitionPrecedente() {
        int ordreProchainStatut = Integer.max((ordre - 1) , 0);
        return StatutFdt.values()[ordreProchainStatut];
    }
}
