package fr.polytech.devfullstack.controller;

import fr.polytech.devfullstack.dto.request.AddEvaluationDto;
import fr.polytech.devfullstack.dto.response.EvaluationDto;
import fr.polytech.devfullstack.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EvaluationController {
    private final EvaluationService evaluationService;

    @PostMapping("/restaurants/{restoId}/evaluation")
    public EvaluationDto addEvaluation(@PathVariable Integer restoId, @Valid @RequestBody AddEvaluationDto addEvaluationDto){
        return EvaluationDto.buildFromEntity(this.evaluationService.addEvaluationToRestaurant(restoId, addEvaluationDto));
    }
}
