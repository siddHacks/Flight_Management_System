package com.flight_reservation_app.service;

import com.flight_reservation_app.entity.Reservation;

import dto.ReservationRequest;
import dto.ReservationUpdateRequest;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request); 
	
	public Reservation getAllData(Long id);
	public Reservation updateReservation(ReservationUpdateRequest data);
}
