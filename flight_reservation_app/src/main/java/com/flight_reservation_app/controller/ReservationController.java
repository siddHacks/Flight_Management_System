package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.service.ReservationService;

import dto.ReservationRequest;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId",reservation.getId());
		return "confirmReservation";
	}

}
