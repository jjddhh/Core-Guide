package com.springboot.guide.jpa.controller;

import com.springboot.guide.jpa.data.dto.ChangeProductNameDTO;
import com.springboot.guide.jpa.data.dto.ProductDTO;
import com.springboot.guide.jpa.data.dto.ProductResponseDTO;
import com.springboot.guide.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 예제 6.27
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<ProductResponseDTO> getProduct(Long number) {
        ProductResponseDTO ProductResponseDTO = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(ProductResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDto) {
        ProductResponseDTO ProductResponseDTO = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(ProductResponseDTO);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDTO> changeProductName(
            @RequestBody ChangeProductNameDTO changeProductNameDto) throws Exception {
        ProductResponseDTO ProductResponseDTO = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(ProductResponseDTO);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
