package com.example.demo.entity.kitchen;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Kitchen {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
