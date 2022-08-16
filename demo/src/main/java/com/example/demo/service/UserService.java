package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Page<User> listPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));

    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void update(Long id, User dto) {
        userRepository.findById(id);
        userRepository.save(dto);
    }

    public void delete(Long id) {
        userRepository.findById(id);
        userRepository.deleteById(id);
    }
}
