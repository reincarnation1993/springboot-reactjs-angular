package com.springbootexample.dtos;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GenericResponseObject<T> {
    private LocalDateTime timestamp;
    private String message;
    private String status;
    private T data;
}