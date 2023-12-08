package fr.polytech.devfullstack.service;

import fr.polytech.devfullstack.controller.EvaluationController;
import fr.polytech.devfullstack.dto.request.AddEvaluationDto;
import fr.polytech.devfullstack.entity.EvaluationEntity;
import fr.polytech.devfullstack.entity.RestaurantEntity;
import fr.polytech.devfullstack.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluationToRestaurant(final Integer restoId, final AddEvaluationDto dto){
        final RestaurantEntity restaurant = this.restaurantService.getRestaurantById(restoId);

        final EvaluationEntity evaluation = EvaluationEntity.builder()
                .commentaire(dto.getCommentaire())
                .note(dto.getNote())
                .date_creation(new Date())
                .date_maj(new Date())
                .nom_eval(dto.getNom_eval())
                .restaurant(restaurant)
                .build();
        return this.evaluationRepository.save(evaluation);
    }

}
