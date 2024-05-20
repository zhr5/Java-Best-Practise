package com.javaedge.java8.completablefuture.myCompletableFuture;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasticFutureTest {
    @Autowired
    private  Services services;

    ExecutorService executor = Executors.newFixedThreadPool(10);

    @Test
    public void testBasticFuture() throws ExecutionException, InterruptedException {
        Long id=Long.valueOf(1);
        // 1. 查询飞机票
        Future<List<Flight>> futureFlights = executor.submit(() -> services.searchFlights(id));

        List<Flight> flights=new ArrayList<>();
        try {
            flights = futureFlights.get();
        } catch (InterruptedException | ExecutionException e) {
            // 处理异常
        }

        // 2. 对每个飞机票查询酒店
        List<Future<List<Hotel>>> futureHotelsList = new ArrayList<>();
        for (Flight flight : flights) {
            Future<List<Hotel>> futureHotels = executor.submit(() ->  services.searchHotels(flight.getId()));
            futureHotelsList.add(futureHotels);
        }

        List<Future<List<TravelPackage>>> futureTravelPackagesList = new ArrayList<>();
        for (Future<List<Hotel>> futureHotels : futureHotelsList) {
            List<Hotel> hotels=new ArrayList<>();
            try {
                hotels = futureHotels.get();
            } catch (InterruptedException | ExecutionException e) {
                // 处理异常
            }

            // 3. 对每个飞机票和酒店的组合计算总价格
            for (Hotel hotel : hotels) {
                Future<TravelPackage> futureTravelPackages = executor.submit(() -> services.calculatePrices(flight, hotel));
                futureTravelPackagesList.add(futureTravelPackages);
            }
        }

        List<TravelPackage> travelPackages = new ArrayList<>();
        for (Future<List<TravelPackage>> futureTravelPackages : futureTravelPackagesList) {
            try {
                travelPackages.addAll(futureTravelPackages.get());
            } catch (InterruptedException | ExecutionException e) {
                // 处理异常
            }
        }

        // 4. 将所有的旅行套餐按照价格排序
        travelPackages.sort(Comparator.comparing(TravelPackage::getPrice));

        // 5. 返回结果
        return travelPackages;
    }
}
