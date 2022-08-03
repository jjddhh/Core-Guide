package com.springboot.guide.jpa.data.dao.impl;
import java.time.LocalDateTime;
import java.util.Optional;

import com.springboot.guide.jpa.data.entity.Product;
import com.springboot.guide.jpa.data.dao.ProductDAO;
import com.springboot.guide.jpa.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 예제 6.10
@RequiredArgsConstructor
@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;


    // 예제 6.11
    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    // 예제 6.12
    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);

        return selectedProduct;
    }

    // 예제 6.15
    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

    // 예제 6.17
    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}