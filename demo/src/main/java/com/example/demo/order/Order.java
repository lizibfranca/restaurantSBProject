package com.example.demo.order;

import com.example.demo.adress.Adress;
import com.example.demo.paymentMethod.PaymentMethod;
import com.example.demo.restaurant.Restaurant;
import com.example.demo.user.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;
    private BigDecimal subtotal;
    private BigDecimal shippingRate;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private LocalDateTime confirmationDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime cancellationDate;
    @OneToOne
    private PaymentMethod paymentMethod;
    @OneToOne
    private User client;
    @Embedded
    private Adress adress;
    private Status status;
    private OrderedItem orderedItem;
    private List<OrderedItem> orderedItemList;
    @OneToOne
    private Restaurant restaurant;




}
