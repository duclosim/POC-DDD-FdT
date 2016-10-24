package fr.excilys.service.mapper;

import fr.excilys.domain.fdt.Mois;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sduclos on 24/10/16.
 */
public class MoisMapperTest {

    private static MoisMapper mapper;

    @BeforeClass
    public static void init() {
        mapper = new MoisMapper();
    }

    @Test
    public void toDTO_doit_mapper_les_champs_en_un_LocalDate_du_1er_du_mois_et_de_l_année_du_Mois() {
        // GIVEN
        int annee = 2016;
        int moisDeLAnnee = 4;
        Mois mois = new Mois(annee, moisDeLAnnee);
        // WHEN
        LocalDate result = mapper.toDTO(mois);
        // THEN
        assertThat(result.getYear()).isEqualTo(annee);
        assertThat(result.getMonthValue()).isEqualTo(moisDeLAnnee);
        assertThat(result.getDayOfMonth()).isEqualTo(1);
    }

    @Test
    public void fromDTO_doit_mapper_les_champs_en_un_LocalDate_du_1er_du_mois_et_de_l_année_du_Mois() {
        // GIVEN
        int annee = 2016;
        int moisDeLAnnee = 4;
        LocalDate date = LocalDate.of(annee, moisDeLAnnee, 1);
        // WHEN
        Mois result = mapper.fromDTO(date);
        // THEN
        assertThat(result.annee).isEqualTo(annee);
        assertThat(result.mois).isEqualTo(moisDeLAnnee);
    }
}
