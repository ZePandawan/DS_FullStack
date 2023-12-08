package fr.polytech.devfullstack.service;


import fr.polytech.devfullstack.dto.response.RestaurantDto;
import fr.polytech.devfullstack.entity.RestaurantEntity;
import fr.polytech.devfullstack.exception.*;
import fr.polytech.devfullstack.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final S3Service s3Service;

    public List<RestaurantEntity> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public List<RestaurantEntity> getRestaurants(final List<Integer> idsToFetch) {
        return this.restaurantRepository.findAllById(idsToFetch);
    }

    public RestaurantEntity getRestaurantById(final Integer id) {
        return this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " + not found"));
    }

    /*
    A CHANGER
    public RestaurantEntity addRestaurant(final RestaurantDto restaurantDto) {
        final RestaurantEntity restaurantToInsert = RestaurantEntity.builder().titre(restaurantDto.getTitre()).build();

        return this.restaurantRepository.save(restaurantToInsert);
    }

     */

    public void deleteRestaurant(final Integer id) {
        this.restaurantRepository.deleteById(id);
    }

    /*
    public RestaurantEntity updateRestaurant(int id, String nouveauNom) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("le restaurant d'id " + id + " n'existe pas"));
        restaurantToUpdate.setTitre(nouveauNom);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

     */

    public String getCoverDownloadUrlIllustration(final Integer restaurantId) {
        this.getRestaurantById(restaurantId);

        return this.s3Service.getDownloadUrlIllustration("VR_" + restaurantId);
    }

    public String putCoverDownloadUrlIllustration(final Integer restaurantId) {
        this.getRestaurantById(restaurantId);

        return this.s3Service.putDownloadUrlIllustration("VR_" + restaurantId);
    }

}
