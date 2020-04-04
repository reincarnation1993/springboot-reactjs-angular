package com.springbootexample.dtos.product;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductResponse {
    private String key;
    private String name;
    private LocalDateTime expireDate;
}
