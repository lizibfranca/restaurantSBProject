package com.example.demo.product;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;


}
