package fr.polytech.devfullstack.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="evaluations_finales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationFinaleEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom_decideur", columnDefinition = "varchar(90)", nullable = false)
    private String nom_decideur;

    @Column(name = "note", columnDefinition = "integer", nullable = false)
    @Min(0)
    @Max(3)
    private Integer note;

    @Column(name = "texte_descriptif", columnDefinition = "text", nullable = false)
    private String texte_descriptif;

    @ManyToOne()
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;
}
