package com.nobodyiam.spring.in.action.reservation.client.service;

import com.nobodyiam.spring.in.action.reservation.client.dto.Reservation;
import java.util.Collections;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceFallback implements ReservationService {

  @Override
  public Resources<Reservation> queryReservations() {
    return new Resources<>(Collections.emptyList());
  }

}
