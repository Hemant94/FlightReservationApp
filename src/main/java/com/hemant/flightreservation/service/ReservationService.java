package com.hemant.flightreservation.service;

import com.hemant.flightreservation.dto.ReservationRequest;
import com.hemant.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
