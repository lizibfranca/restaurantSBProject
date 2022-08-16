package com.example.demo.order;

import com.example.demo.product.Product;
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
