package com.flight_reservation_app.service;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.FlightRepository;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;
import com.flight_reservation_app.utilities.EmailUtil;
import com.flight_reservation_app.utilities.PDFgenerator;

import dto.ReservationRequest;
import dto.ReservationUpdateRequest;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PDFgenerator pdFgenerator; 
	
	@Autowired
	private EmailUtil email;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		Flight flight = flightRepo.findById(request.getFlightId()).get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath = "C:\\Users\\HP\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\flight_reservation_app\\tickets\\reservation"+reservation.getId()+".pdf";
		Reservation ans = reservationRepo.save(reservation);
		pdFgenerator.generatePDF(reservation , filePath);
		email.emailSending(passenger.getEmail(), filePath);
		return ans;
	}

	@Override
	public Reservation getAllData(Long id) {
		Reservation result = reservationRepo.findById(id).get();
		return result;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest data) {
		Reservation result = reservationRepo.findById(data.getId()).get();
		result.setCheckedIn(data.isCheckedIn());
		result.setNumberOfBags(data.getNumberOfBags());
		reservationRepo.save(result);
		return result;
	}
	

}
