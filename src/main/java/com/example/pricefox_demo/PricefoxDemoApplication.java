package com.example.pricefox_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PricefoxDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(PricefoxDemoApplication.class, args);

    ConwayGame.runGame();

  }
}


