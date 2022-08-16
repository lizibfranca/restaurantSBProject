package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.StateRepository;
import com.example.demo.state.State;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;

    public Page<State> listPage(Pageable pageable){
        return stateRepository.findAll(pageable);
    }

    public List<State> listAll(){
        return stateRepository.findAll();
    }

    public State getStateById(long id) {
        return stateRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("State not found"));

    }

    @Transactional
    public State save(State state) {
        return stateRepository.save(state);
    }

    @Transactional
    public void update(Long id, State dto) {
        stateRepository.findById(id);
        stateRepository.save(dto);
    }

    public void delete(Long id) {
        stateRepository.findById(id);
        stateRepository.deleteById(id);
    }
}
