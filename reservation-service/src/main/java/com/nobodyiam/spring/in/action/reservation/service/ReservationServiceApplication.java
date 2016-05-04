package com.nobodyiam.spring.in.action.reservation.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Jason on 5/3/16.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ReservationServiceApplication.class)
            .run(args);
  }
}
