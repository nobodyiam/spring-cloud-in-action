package com.nobodyiam.spring.in.action.reservation.service;

import com.nobodyiam.spring.in.action.reservation.service.entity.Reservation;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Jason on 5/3/16.
 */
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {
  List<Reservation> findByReservationName(String reservationName);
}
