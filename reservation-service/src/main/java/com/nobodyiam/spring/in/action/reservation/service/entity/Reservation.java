package com.nobodyiam.spring.in.action.reservation.service.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jason on 5/3/16.
 */
@Entity
public class Reservation {
  @Id
  @GeneratedValue
  private Long id;

  private String reservationName;

  public Reservation() {
  }

  public Reservation(String reservationName) {
    this.reservationName = reservationName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getReservationName() {
    return reservationName;
  }

  public void setReservationName(String reservationName) {
    this.reservationName = reservationName;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .omitNullValues()
            .add("id", id)
            .add("reservationName", reservationName)
            .toString();
  }
}
