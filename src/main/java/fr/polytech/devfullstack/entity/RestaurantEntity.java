package fr.polytech.devfullstack.entity;


import fr.polytech.devfullstack.dto.response.EvaluationFinaleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name="restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantEntity {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(90)", nullable = false)
    private String nom;

    @Column(name = "adresse", columnDefinition = "varchar(255)", nullable = false)
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;

    // Pas forcemment nécessaire
    /*
    @Column(name = "moyenne", columnDefinition = "DOUBLE", nullable = false)
    private double moyenne;
     */

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationFinaleEntity> eval_finale;

    /*@ManyToMany
    @JoinTable(
            name = "restaurant_tag",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagEntity> tags;

     */
    @OneToMany(mappedBy = "restaurant")
    private List<TagEntity> tags;
}
