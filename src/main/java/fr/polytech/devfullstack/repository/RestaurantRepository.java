package fr.polytech.devfullstack.repository;

import fr.polytech.devfullstack.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
}
