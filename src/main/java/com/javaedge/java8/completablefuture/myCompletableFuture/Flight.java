package com.javaedge.java8.completablefuture.myCompletableFuture;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


/*
* 机票
* */
@Data
@RequiredArgsConstructor
public class Flight {

    private final Long id;
    private final String name;
    private final BigDecimal price;
}
