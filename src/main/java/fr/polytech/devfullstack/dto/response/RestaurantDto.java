package fr.polytech.devfullstack.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.devfullstack.entity.RestaurantEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @Size(max=90)
    private String nom;

    @JsonProperty("adresse")
    @Size(max=255)
    private String adresse;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("moyenne_eval")
    private double moyenne_eval;

    @JsonProperty("evaluation_finale")
    private List<EvaluationFinaleDto> evaluation_finale;

    @JsonProperty("tags")
    private List<TagDto> tags;

    public static RestaurantDto buildFromEntity(RestaurantEntity restaurantEntity){
        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .moyenne_eval(restaurantEntity.getMoyenne())
                .evaluations(restaurantEntity.getEvaluations().stream().map(evaluationEntity -> EvaluationDto.buildFromEntity(evaluationEntity)).toList())
                .evaluation_finale(restaurantEntity.getEval_finale().stream().map(evaluationFinaleEntity -> EvaluationFinaleDto.buildFromEntity(evaluationFinaleEntity)).toList())
                .tags(restaurantEntity.getTags().stream().map(tagEntity -> TagDto.buildFromEntity(tagEntity)).toList())
                .build();

    }


}
