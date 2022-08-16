package com.example.demo.entity.order;

import com.example.demo.entity.product.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderedItem {

    private Integer quantity;
    private BigDecimal unityPrice;
    private BigDecimal totalPrice;
    private String observation;
    private Product product;
}
