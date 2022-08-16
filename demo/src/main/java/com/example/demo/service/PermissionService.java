package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.entity.permission.Permission;
import com.example.demo.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public Page<Permission> listPage(Pageable pageable){
        return permissionRepository.findAll(pageable);
    }

    public List<Permission> listAll(){
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(long id) {
        return permissionRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Permission not found"));

    }

    @Transactional
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Transactional
    public void update(Long id, Permission dto) {
        permissionRepository.findById(id);
        permissionRepository.save(dto);
    }

    public void delete(Long id) {
        permissionRepository.findById(id);
        permissionRepository.deleteById(id);
    }
}
