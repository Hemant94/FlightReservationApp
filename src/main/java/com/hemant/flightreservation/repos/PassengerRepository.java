package com.hemant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemant.flightreservation.entities.Passenger;
import com.hemant.flightreservation.entities.User;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	

}
