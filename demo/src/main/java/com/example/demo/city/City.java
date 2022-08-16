package com.example.demo.city;

import com.example.demo.state.State;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class City {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @OneToOne
    private State state;

}
