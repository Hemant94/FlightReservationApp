package com.hemant.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.flightreservation.dto.ReservationRequest;
import com.hemant.flightreservation.entities.Flight;
import com.hemant.flightreservation.entities.Passenger;
import com.hemant.flightreservation.entities.Reservation;
import com.hemant.flightreservation.repos.FlightRepository;
import com.hemant.flightreservation.repos.PassengerRepository;
import com.hemant.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository repository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payment
		
		Long flightId = request.getFlightId();
		Flight flight= repository.findOne(flightId);
		
		Passenger passenger= new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation= new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
