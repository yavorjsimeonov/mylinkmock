package com.form76.mylinkmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.form76.mylinkmock", "com.form76.mylinkmock"})

public class MylinkMockApplication {

  public static void main(String[] args) {
    SpringApplication.run(MylinkMockApplication.class, args);
  }

}
