package com.springboot.guide.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 예제 6.28
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangeProductNameDTO {

    private Long number;

    private String name;

}