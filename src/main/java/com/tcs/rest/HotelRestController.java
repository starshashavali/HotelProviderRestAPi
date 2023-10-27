package com.tcs.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.HotelBookingResponse;
import com.tcs.dto.HotelsBookingRequest;
import com.tcs.service.IHotelBookingService;

@RestController
@Valid
public class HotelRestController {

	@Autowired
	private IHotelBookingService service;

	@PostMapping("/save")
	public ResponseEntity<?> bookHotels(@Valid @RequestBody HotelsBookingRequest request) {
		HotelBookingResponse bookHotel = service.bookHotel(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookHotel);
	}

	@GetMapping("/hotel/{id}")
	public ResponseEntity<?> getHotels(@Valid @PathVariable Integer id) {
		HotelBookingResponse hotelById = service.getHotelById(id);
		return ResponseEntity.status(HttpStatus.OK).body(hotelById);
	}

	@GetMapping("/getAllRooms")
	public ResponseEntity<?> getAllRooms() {
		List<HotelBookingResponse> rooms = service.getAllHotelRooms();
		return ResponseEntity.status(HttpStatus.OK).body(rooms);
	}

	@DeleteMapping("Hotel/{roomNo}")
	public ResponseEntity<?> deleteHotelRoom(@Valid @PathVariable Integer roomNo) {
		service.cancelRoom(roomNo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
