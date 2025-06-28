package com.example.dtos;

import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreCategoryResponseDto {
    private String status;
    private String message;
    private List<String> categories;
}
