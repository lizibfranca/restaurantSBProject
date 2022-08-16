package com.example.demo.service;

import com.example.demo.adress.Adress;
import com.example.demo.city.City;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public Page<City> listPage(Pageable pageable){
        return cityRepository.findAll(pageable);
    }

    public List<City> listAll(){
        return cityRepository.findAll();
    }

    public City getCityById(long id) {
        return cityRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("City not found"));

    }

    @Transactional
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public void update(Long id, City dto) {
        cityRepository.findById(id);
        cityRepository.save(dto);
    }

    public void delete(Long id) {
        cityRepository.findById(id);
        cityRepository.deleteById(id);
    }
}
