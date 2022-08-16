package com.example.demo.entity.group;

import com.example.demo.entity.permission.Permission;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Group {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private List<Permission> permissionList;

}
