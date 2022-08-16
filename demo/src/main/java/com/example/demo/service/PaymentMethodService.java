package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.entity.paymentMethod.PaymentMethod;
import com.example.demo.repository.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public Page<PaymentMethod> listPage(Pageable pageable){
        return paymentMethodRepository.findAll(pageable);
    }

    public List<PaymentMethod> listAll(){
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod getPaymentMethodById(long id) {
        return paymentMethodRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("PayMethod not found"));

    }

    @Transactional
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Transactional
    public void update(Long id, PaymentMethod dto) {
        paymentMethodRepository.findById(id);
        paymentMethodRepository.save(dto);
    }

    public void delete(Long id) {
        paymentMethodRepository.findById(id);
        paymentMethodRepository.deleteById(id);
    }
}
