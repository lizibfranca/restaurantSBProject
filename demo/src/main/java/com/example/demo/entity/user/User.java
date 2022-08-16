package com.example.demo.entity.user;

import com.example.demo.entity.group.Group;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime registerDate;
    @OneToOne
    private Group group;
}
