package com.javaedge.java8.completablefuture.myCompletableFuture;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/*
 * 旅行套餐
 * */
@Data
@RequiredArgsConstructor
public class TravelPackage {
    private final Long id;
    private final String name;
    private final BigDecimal price;
}
