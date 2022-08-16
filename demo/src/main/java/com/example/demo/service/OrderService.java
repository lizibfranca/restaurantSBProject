package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.entity.order.Order;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Page<Order> listPage(Pageable pageable){
        return orderRepository.findAll(pageable);
    }

    public List<Order> listAll(){
        return orderRepository.findAll();
    }

    public Order getOrderById(long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Order not found"));

    }

    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void update(Long id, Order dto) {
        orderRepository.findById(id);
        orderRepository.save(dto);
    }

    public void delete(Long id) {
        orderRepository.findById(id);
        orderRepository.deleteById(id);
    }
}
