package com.springboot.guide.jpa.service;

import com.springboot.guide.jpa.data.dto.ProductDTO;
import com.springboot.guide.jpa.data.dto.ProductResponseDTO;

// 예제 6.21
public interface ProductService {

    ProductResponseDTO getProduct(Long number);

    ProductResponseDTO saveProduct(ProductDTO productDto);

    ProductResponseDTO changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}