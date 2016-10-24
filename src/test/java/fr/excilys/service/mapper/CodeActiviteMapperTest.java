package fr.excilys.service.mapper;

import fr.excilys.domain.fdt.CodeActivite;
import fr.excilys.domain.fdt.Periode;
import fr.excilys.service.dto.CodeActiviteInfraDTO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sduclos on 24/10/16.
 */
public class CodeActiviteMapperTest {

    private static CodeActiviteMapper mapper;

    @BeforeClass
    public static void init() {
        mapper = new CodeActiviteMapper();
    }

    @Test
    public void fromDTO_doit_mapper_les_champs_correctement_et_la_période_doit_être_vide() {
        // GIVEN
        CodeActiviteInfraDTO dto = new CodeActiviteInfraDTO();
        dto.id = 145525L;
        dto.code = "I'm Batman";
        dto.periode = null;
        // WHEN
        CodeActivite result = mapper.fromDTO(dto);
        // THEN
        assertThat(result.getIdCodeActivite()).isEqualTo(dto.id);
        assertThat(result.getCode()).isEqualTo(dto.code);
        assertThat(result.getPeriodeValidite().isPresent()).isFalse();
    }

    @Test
    public void fromDTO_doit_mapper_les_champs_correctement() {
        // GIVEN
        CodeActiviteInfraDTO dto = new CodeActiviteInfraDTO();
        dto.id = 145525L;
        dto.code = "Have you ever danced with the devil in the pale moon light ?";
        dto.periode = new Periode(LocalDateTime.now(), LocalDateTime.now());
        // WHEN
        CodeActivite result = mapper.fromDTO(dto);
        // THEN
        assertThat(result.getIdCodeActivite()).isEqualTo(dto.id);
        assertThat(result.getCode()).isEqualTo(dto.code);
        assertThat(result.getPeriodeValidite().isPresent()).isTrue();
        assertThat(result.getPeriodeValidite().get()).isEqualTo(dto.periode);
    }

    @Test
    public void toDTO_doit_mapper_les_champs_correctement_et_la_période_doit_rester_à_null() {
        // GIVEN
        CodeActivite codeActivite = new CodeActivite.Builder()
                .withId(45585L)
                .withCode("Do you know what it's like ... to be the bad man. Behind blue eyes.")
                .withPeriodeValidite(Optional.empty())
                .build();
        // WHEN
        CodeActiviteInfraDTO result = mapper.toDTO(codeActivite);
        // THEN
        assertThat(result.id).isEqualTo(codeActivite.getIdCodeActivite());
        assertThat(result.code).isEqualTo(codeActivite.getCode());
        assertThat(result.periode).isEqualTo(null);
    }

    @Test
    public void toDTO_doit_mapper_les_champs_correctement() {
        // GIVEN
        CodeActivite codeActivite = new CodeActivite.Builder()
                .withId(45585L)
                .withCode("'Cause I'm bad to the bone.")
                .withPeriodeValidite(Optional.of(new Periode(LocalDateTime.now(), LocalDateTime.now())))
                .build();
        // WHEN
        CodeActiviteInfraDTO result = mapper.toDTO(codeActivite);
        // THEN
        assertThat(result.id).isEqualTo(codeActivite.getIdCodeActivite());
        assertThat(result.code).isEqualTo(codeActivite.getCode());
        assertThat(result.periode).isEqualTo(codeActivite.getPeriodeValidite().get());
    }
}
