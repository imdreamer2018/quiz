package com.twuc.shopping.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse<T> {

    private Integer code;
    private String message;
    private T data;
}
