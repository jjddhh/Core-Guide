package com.springboot.guide.jpa.data.dto;

import lombok.*;

// 예제 6.19
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {

    private String name;

    private int price;

    private int stock;

}
