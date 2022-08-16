package com.example.demo.entity.restaurant;

import com.example.demo.entity.adress.Adress;
import com.example.demo.entity.kitchen.Kitchen;
import com.example.demo.entity.paymentMethod.PaymentMethod;
import com.example.demo.entity.product.Product;
import com.example.demo.entity.user.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private BigDecimal shippingRate;
    private Boolean active;
    private Boolean open;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private List<User> responsibleList;
    @Embedded
    private Adress adress;
    private List<PaymentMethod> paymentMethodList;
    @OneToOne
    private Kitchen kitchen;
    private List<Product> productList;


}
