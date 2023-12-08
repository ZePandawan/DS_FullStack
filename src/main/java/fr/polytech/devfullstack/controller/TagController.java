package fr.polytech.devfullstack.controller;

import fr.polytech.devfullstack.dto.request.AddEvaluationDto;
import fr.polytech.devfullstack.dto.request.AddTagDto;
import fr.polytech.devfullstack.dto.response.EvaluationDto;
import fr.polytech.devfullstack.dto.response.TagDto;
import fr.polytech.devfullstack.service.EvaluationService;
import fr.polytech.devfullstack.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TagController {
    private final TagService tagService;

    @PostMapping("/restaurants/{restoId}/tags")
    public TagDto addTag(@PathVariable Integer restoId, @Valid @RequestBody AddTagDto addTagDto){
        return TagDto.buildFromEntity(this.tagService.addTagToRestaurant(restoId, addTagDto));
    }
}
