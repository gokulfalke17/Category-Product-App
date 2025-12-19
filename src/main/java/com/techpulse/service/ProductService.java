package com.techpulse.service;

import com.techpulse.dto.ProductDTO;
import com.techpulse.entity.Product;
import com.techpulse.mapper.ProductMapper;
import com.techpulse.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
