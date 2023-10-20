package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.service.ReservationService;

import dto.ReservationUpdateRequest;

@RestController
@RequestMapping("/reservation")
public class ReseravtionRestController {
	
	@Autowired
	private ReservationService reservationService; 
	
	//http://localhost:8080/reservation/1
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> getAllData(@PathVariable("id") Long id){
		Reservation reservation = reservationService.getAllData(id);
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Reservation> updateReservation(@RequestBody ReservationUpdateRequest data) {
		Reservation updateReservation = reservationService.updateReservation(data);
		return new ResponseEntity<Reservation>(updateReservation,HttpStatus.OK);
	}

}
