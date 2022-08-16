package com.example.demo.permission;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Permission {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;

}
