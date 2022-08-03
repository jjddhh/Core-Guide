package com.springboot.guide.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 예제 6.20
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponseDTO {

    private Long number;

    private String name;

    private int price;

    private int stock;

}