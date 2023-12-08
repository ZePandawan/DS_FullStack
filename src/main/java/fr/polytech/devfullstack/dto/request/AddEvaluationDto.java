package fr.polytech.devfullstack.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEvaluationDto {
    @JsonProperty("commentaire")
    private String commentaire;

    @JsonProperty("nom_eval")
    private String nom_eval;

    @JsonProperty("note")
    private Integer note;

    @JsonProperty("date_creation")
    private Date date_creation;

    @JsonProperty("date_maj")
    private Date date_maj;
}
