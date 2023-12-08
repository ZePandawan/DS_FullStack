package fr.polytech.devfullstack.service;

import fr.polytech.devfullstack.dto.request.AddEvaluationDto;
import fr.polytech.devfullstack.dto.request.AddTagDto;
import fr.polytech.devfullstack.entity.EvaluationEntity;
import fr.polytech.devfullstack.entity.RestaurantEntity;
import fr.polytech.devfullstack.entity.TagEntity;
import fr.polytech.devfullstack.repository.EvaluationRepository;
import fr.polytech.devfullstack.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagService {
    private final TagRepository tagRepository;
    private final RestaurantService restaurantService;

    public TagEntity addTagToRestaurant(final Integer restoId, final AddTagDto dto){
        final RestaurantEntity restaurant = this.restaurantService.getRestaurantById(restoId);

        final TagEntity tag = TagEntity.builder()
                .nom(dto.getNom())
                .restaurant(restaurant)
                .build();


        return this.tagRepository.save(tag);
    }
}
