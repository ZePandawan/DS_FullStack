package fr.polytech.devfullstack.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.devfullstack.entity.RestaurantEntity;
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
public class AddTagDto {
    @JsonProperty("nom")
    private String nom;
}
