package com.nobodyiam.spring.in.action.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * open http://localhost:8010/hystrix with stream as http://localhost:9999/actuator/hystrix.stream or http://localhost:9088/turbine.stream
 *
 * Created by Jason on 5/10/16.
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {
  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardApplication.class, args);
  }
}
