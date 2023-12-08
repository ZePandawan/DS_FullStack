package fr.polytech.devfullstack.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.devfullstack.entity.EvaluationFinaleEntity;
import fr.polytech.devfullstack.entity.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    public static TagDto buildFromEntity(TagEntity tagEntity){
        return TagDto.builder()
                .id(tagEntity.getId())
                .nom(tagEntity.getNom())
                .build();
    }
}
