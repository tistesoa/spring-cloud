package com.tistesoa.application;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tistesoa")
public class TistesoaSpringCloudApp {


  public static void main(String[] args) {
    SpringApplication.run(TistesoaSpringCloudApp.class, args);
  }

  @Bean
  public Function<String, String> toStream() {
    return value -> {
      System.out.println("Received: " + value);
      return value.toUpperCase();
    };
  }

//  @Bean
//  public Supplier<Date> date() {
//    return () -> new Date(12345L);
//  }
//
//  @Bean
//  public Function<String, String> uppercase() {
//    return value -> {
//      System.out.println("Received: " + value);
//      return value.toUpperCase();
//    };
//  }

}
