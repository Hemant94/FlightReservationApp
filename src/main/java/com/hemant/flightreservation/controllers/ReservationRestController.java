package com.hemant.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemant.flightreservation.dto.ReservationUpdateRequest;
import com.hemant.flightreservation.entities.Reservation;
import com.hemant.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reseravtions/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		Reservation reservation= reservationRepository.findOne(id);
		return reservation;
	}
	
	@RequestMapping("/reseravtions")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation= reservationRepository.findOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		Reservation updatedReservation = reservationRepository.save(reservation);
		return updatedReservation;
	}
}
