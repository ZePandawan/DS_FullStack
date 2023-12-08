package fr.polytech.devfullstack.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.devfullstack.entity.EvaluationFinaleEntity;
import fr.polytech.devfullstack.entity.RestaurantEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFinaleDto {

    @JsonProperty("nom_decideur")
    @Size(max = 90)
    private String nom_decideur;

    @JsonProperty("note")
    @Min(0)
    @Max(3)
    private Integer note;

    @JsonProperty("texte_descriptif")
    private String texte_descriptif;


    public static EvaluationFinaleDto buildFromEntity(EvaluationFinaleEntity evaluationFinaleEntity){
        return EvaluationFinaleDto.builder()
                .nom_decideur(evaluationFinaleEntity.getNom_decideur())
                .note(evaluationFinaleEntity.getNote())
                .texte_descriptif(evaluationFinaleEntity.getTexte_descriptif())
                .build();
    }
}