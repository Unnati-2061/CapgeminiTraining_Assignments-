package org.example;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Mycalc implements Calc{
    @Override
    public int add(int n ,int t){

      return n +t;
    }


    @PostConstruct
    public void onInit() {

        System.out.println("Initialization method for DBConnect, WebSocket, etc...");
    }
   @PreDestroy
    public void onDestroy() {

        System.out.println("Destructor method for closing connections etc ...");
    }
}
