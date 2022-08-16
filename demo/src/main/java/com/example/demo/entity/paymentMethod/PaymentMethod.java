package com.example.demo.entity.paymentMethod;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PaymentMethod {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

}
