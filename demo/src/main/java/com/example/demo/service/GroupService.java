package com.example.demo.service;

import com.example.demo.city.City;
import com.example.demo.exception.BadRequestException;
import com.example.demo.group.Group;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Page<Group> listPage(Pageable pageable){
        return groupRepository.findAll(pageable);
    }

    public List<Group> listAll(){
        return groupRepository.findAll();
    }

    public Group getGroupById(long id) {
        return groupRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Group not found"));

    }

    @Transactional
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    public void update(Long id, Group dto) {
        groupRepository.findById(id);
        groupRepository.save(dto);
    }

    public void delete(Long id) {
        groupRepository.findById(id);
        groupRepository.deleteById(id);
    }
}
