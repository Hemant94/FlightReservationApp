package com.hemant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemant.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	

}
