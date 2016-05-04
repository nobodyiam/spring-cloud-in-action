package com.nobodyiam.spring.cloud.in.action.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Jason on 5/4/16.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServiceApplication.class, args);
  }
}
