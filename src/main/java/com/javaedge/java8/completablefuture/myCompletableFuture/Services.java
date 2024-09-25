package com.javaedge.java8.completablefuture.myCompletableFuture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class Services {

    public static List<Flight> searchFlights(Long id){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Flight f1= new Flight(id,"飞机票"+id, BigDecimal.valueOf(10));
        Flight f2= new Flight(id+1,"飞机票"+id+1,BigDecimal.valueOf(20));
        List<Flight> res=new ArrayList<>();
        res.add(f1);
        res.add(f2);
        return res;
    }

    public static List<Hotel> searchHotels(Long id){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Hotel h1= new Hotel(id,"酒店"+id,BigDecimal.valueOf(10));
        Hotel h2= new Hotel(id+1,"酒店"+id+1,BigDecimal.valueOf(20));
        List<Hotel> res=new ArrayList<>();
        res.add(h1);
        res.add(h2);
        return res;
    }

    public static void calculatePrices(Flight flight,Hotel hotel){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}