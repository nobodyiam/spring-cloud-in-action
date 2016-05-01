package com.nobodyiam.spring.cloud.in.action.config.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason on 2/24/16.
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class ConfigServerApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ConfigServerApplication.class)
            .run(args);
  }

}
