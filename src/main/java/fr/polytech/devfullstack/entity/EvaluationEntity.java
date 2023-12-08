package fr.polytech.devfullstack.entity;


import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "evaluations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationEntity {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name="nom_eval", columnDefinition = "varchar(50)", nullable = false)
    private String nom_eval;

    @Column(name = "commentaire", columnDefinition = "varchar(255)", nullable = false)
    private String commentaire;

    @Column(name = "note", columnDefinition = "integer", nullable = false)
    @Min(0)
    @Max(3)
    private Integer note;

    @Column(name = "date_creation", columnDefinition = "DATETIME")
    private Date date_creation;

    @Column(name = "date_maj", columnDefinition = "DATETIME")
    private Date date_maj;

    @ManyToOne()
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;
}
