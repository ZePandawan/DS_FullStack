package fr.polytech.devfullstack.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.devfullstack.entity.EvaluationEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {

    @JsonProperty("id")
    @Min(0)
    private Integer id;

    @JsonProperty("nom_evaluateur")
    @Size(max = 50)
    private String nom_evaluateur;

    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("note_recommandee")
    @Min(0)
    @Max(3)
    private Integer note_recommandee;

    @JsonProperty("date_creation")
    private Date date_creation;

    @JsonProperty("date_mise_a_jour")
    private Date date_mise_a_jour;

    public static EvaluationDto buildFromEntity(EvaluationEntity evaluationEntity){
        return EvaluationDto.builder()
                .id(evaluationEntity.getId())
                .nom_evaluateur(evaluationEntity.getNom_eval())
                .commentaire(evaluationEntity.getCommentaire())
                .note_recommandee(evaluationEntity.getNote())
                .date_creation(evaluationEntity.getDate_creation())
                .date_mise_a_jour(evaluationEntity.getDate_maj())
                .build();
    }
}
