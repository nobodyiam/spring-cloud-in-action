package com.nobodyiam.spring.in.action.reservation.service.controller;

import com.google.common.collect.Lists;

import com.nobodyiam.spring.in.action.reservation.service.ReservationRepository;
import com.nobodyiam.spring.in.action.reservation.service.entity.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jason on 5/3/16.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationController {
  @Autowired
  private ReservationRepository reservationRepository;

  @RequestMapping(method = RequestMethod.GET)
  public List<Reservation> queryReservationsByName(@RequestParam(value = "reservationName") String reservationName,
                                                   @RequestParam(value = "offset", defaultValue = "0") int offset,
                                                   @RequestParam(value = "limit", defaultValue = "10") int limit,
                                                   HttpServletResponse response) throws IOException {
    return Lists.newArrayList();
  }
}
