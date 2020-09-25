package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private Integer price;

    @NotEmpty
    private String unit;

    @NotEmpty
    private String imgLink;
}
