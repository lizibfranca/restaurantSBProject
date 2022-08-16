package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.kitchen.Kitchen;
import com.example.demo.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class KitchenService {

    private final KitchenRepository kitchenRepository;

    public Page<Kitchen> listPage(Pageable pageable){
        return kitchenRepository.findAll(pageable);
    }

    public List<Kitchen> listAll(){
        return kitchenRepository.findAll();
    }

    public Kitchen getKitchenById(long id) {
        return kitchenRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Kitchen not found"));

    }

    @Transactional
    public Kitchen save(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    @Transactional
    public void update(Long id, Kitchen dto) {
        kitchenRepository.findById(id);
        kitchenRepository.save(dto);
    }

    public void delete(Long id) {
        kitchenRepository.findById(id);
        kitchenRepository.deleteById(id);
    }
}
