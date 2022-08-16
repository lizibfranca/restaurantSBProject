package com.example.demo.user;

import com.example.demo.group.Group;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
