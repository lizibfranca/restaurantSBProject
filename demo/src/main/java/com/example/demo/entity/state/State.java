package com.example.demo.entity.state;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class State {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
