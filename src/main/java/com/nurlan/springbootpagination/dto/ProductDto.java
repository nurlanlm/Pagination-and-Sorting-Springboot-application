package com.nurlan.springbootpagination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private LocalDateTime createdAt;
}
