package com.springboot.guide.jpa.service.Impl;

import com.springboot.guide.jpa.data.dao.ProductDAO;
import com.springboot.guide.jpa.data.dto.ProductDTO;
import com.springboot.guide.jpa.data.dto.ProductResponseDTO;
import com.springboot.guide.jpa.data.entity.Product;
import com.springboot.guide.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    // 예제 6.23
    @Override
    public ProductResponseDTO getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDTO ProductResponseDTO = new ProductResponseDTO();
        ProductResponseDTO.setNumber(product.getNumber());
        ProductResponseDTO.setName(product.getName());
        ProductResponseDTO.setPrice(product.getPrice());
        ProductResponseDTO.setStock(product.getStock());

        return ProductResponseDTO;
    }

    // 예제 6.24
    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDTO ProductResponseDTO = new ProductResponseDTO();
        ProductResponseDTO.setNumber(savedProduct.getNumber());
        ProductResponseDTO.setName(savedProduct.getName());
        ProductResponseDTO.setPrice(savedProduct.getPrice());
        ProductResponseDTO.setStock(savedProduct.getStock());

        return ProductResponseDTO;
    }

    // 예제 6.25
    @Override
    public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDTO ProductResponseDTO = new ProductResponseDTO();
        ProductResponseDTO.setNumber(changedProduct.getNumber());
        ProductResponseDTO.setName(changedProduct.getName());
        ProductResponseDTO.setPrice(changedProduct.getPrice());
        ProductResponseDTO.setStock(changedProduct.getStock());

        return ProductResponseDTO;
    }

    // 예제 6.26
    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}