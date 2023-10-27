package com.tcs.service;

import java.util.List;

import com.tcs.dto.HotelBookingResponse;
import com.tcs.dto.HotelsBookingRequest;

public interface IHotelBookingService {

	public HotelBookingResponse bookHotel(HotelsBookingRequest request);

	public HotelBookingResponse getHotelById(Integer roomNo);

	public List<HotelBookingResponse> getAllHotelRooms();

	public void cancelRoom(Integer roomNo);

}
