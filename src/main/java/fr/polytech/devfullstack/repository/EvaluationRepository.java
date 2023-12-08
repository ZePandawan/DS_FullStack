package fr.polytech.devfullstack.repository;

import fr.polytech.devfullstack.entity.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {
}
