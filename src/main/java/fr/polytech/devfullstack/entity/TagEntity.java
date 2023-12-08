package fr.polytech.devfullstack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name="tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    // Relation avec la classe RestaurantEntity

    @ManyToOne
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;
}
