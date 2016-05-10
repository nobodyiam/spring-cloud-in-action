package com.nobodyiam.spring.in.action.reservation.client.controller;

import com.google.common.collect.FluentIterable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nobodyiam.spring.in.action.reservation.client.dto.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Jason on 5/10/16.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationApiGatewayRestController {
  @Autowired
  @LoadBalanced
  private RestTemplate rt;

  private Collection<String> getReservationNamesFallback() {
    return Collections.emptyList();
  }

  @RequestMapping("/names")
  @HystrixCommand(fallbackMethod = "getReservationNamesFallback")
  public Collection<String> getReservationNames() {

    ParameterizedTypeReference<Resources<Reservation>> parameterizedTypeReference =
            new ParameterizedTypeReference<Resources<Reservation>>() {
            };

    ResponseEntity<Resources<Reservation>> exchange = rt.exchange(
            "http://reservation-service/reservations",
            HttpMethod.GET, null, parameterizedTypeReference);

    return FluentIterable.from(exchange.getBody().getContent())
            .transform(Reservation::getReservationName).toList();
  }
}
