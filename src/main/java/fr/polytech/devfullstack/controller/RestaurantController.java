package fr.polytech.devfullstack.controller;

import fr.polytech.devfullstack.dto.response.RestaurantDto;
import fr.polytech.devfullstack.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;


    // Fonctionne
    @GetMapping("/restaurants")
    public List<RestaurantDto> getRestaurants(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.restaurantService.getRestaurants().stream().map(restaurantEntity -> RestaurantDto.buildFromEntity(restaurantEntity)).toList();
        } else {
            return this.restaurantService.getRestaurants(idsToFetch).stream().map(restaurantEntity -> RestaurantDto.buildFromEntity(restaurantEntity)).toList();
        }
    }

    // Fonctionne
    @GetMapping("/restaurants/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Integer id) {
        return RestaurantDto.buildFromEntity(this.restaurantService.getRestaurantById(id));
    }


    // A tester
    @GetMapping("/restaurants/{id}/cover")
    public String getRestaurantCoverById(@PathVariable Integer id) {
        return this.restaurantService.getCoverDownloadUrlIllustration(id);
    }

    // A tester
    @PutMapping("/restaurants/{id}/cover")
    public String putRestaurantCoverById(@PathVariable Integer id) {
        return this.restaurantService.putCoverDownloadUrlIllustration(id);
    }

    /*
    @PostMapping("/restaurants")
    public RestaurantDto addRestaurant(@Valid @RequestBody RestaurantDto restaurantDto) {
        return RestaurantDto.buildFromEntity(this.restaurantService.addRestaurant(restaurantDto));
    }

     */


    // Fonctionne
    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable Integer id) {
        this.restaurantService.deleteRestaurant(id);
    }

}
