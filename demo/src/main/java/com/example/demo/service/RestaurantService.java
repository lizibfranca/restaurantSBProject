package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.entity.restaurant.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Page<Restaurant> listPage(Pageable pageable){
        return restaurantRepository.findAll(pageable);
    }

    public List<Restaurant> listAll(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(long id) {
        return restaurantRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Restaurant not found"));

    }

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void update(Long id, Restaurant dto) {
        restaurantRepository.findById(id);
        restaurantRepository.save(dto);
    }

    public void delete(Long id) {
        restaurantRepository.findById(id);
        restaurantRepository.deleteById(id);
    }
}
