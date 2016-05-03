package com.nobodyiam.spring.in.action.reservation.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Jason on 5/3/16.
 */
@SpringBootApplication
public class ReservationServiceApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ReservationServiceApplication.class)
            .run(args);
  }
}
