package com.example.demo.service;

import com.example.demo.adress.Adress;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.AdressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdressService {

    private final AdressRepository adressRepository;

    public Page<Adress> listPage(Pageable pageable){
        return adressRepository.findAll(pageable);
    }

    public List<Adress> listAll(){
        return adressRepository.findAll();
    }

    public Adress getAdressById(long id) {
        return adressRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Adress not found"));

    }

    @Transactional
    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }

    @Transactional
    public void update(Long id, Adress dto) {
        adressRepository.findById(id);
        adressRepository.save(dto);
    }

    public void delete(Long id) {
        adressRepository.findById(id);
        adressRepository.deleteById(id);
    }
}
