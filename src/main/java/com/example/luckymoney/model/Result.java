package com.example.luckymoney.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;
}
