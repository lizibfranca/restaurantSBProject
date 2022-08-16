package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.entity.product.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> listPage(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Product not found"));

    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void update(Long id, Product dto) {
        productRepository.findById(id);
        productRepository.save(dto);
    }

    public void delete(Long id) {
        productRepository.findById(id);
        productRepository.deleteById(id);
    }
}
