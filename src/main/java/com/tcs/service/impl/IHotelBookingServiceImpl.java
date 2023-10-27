package com.tcs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tcs.dto.HotelBookingResponse;
import com.tcs.dto.HotelsBookingRequest;
import com.tcs.exception.RoomNumberNotFoundException;
import com.tcs.service.IHotelBookingService;

@Service
public class IHotelBookingServiceImpl implements IHotelBookingService {

	private Map<Integer, HotelBookingResponse> responseMap = new HashMap<>();

	private Integer roomNo = 1;

	@Override
	public HotelBookingResponse bookHotel(HotelsBookingRequest request) {
		HotelBookingResponse response = new HotelBookingResponse();
		BeanUtils.copyProperties(request, response);
		response.setPrice("399.0");
		response.setBookStatus("Confirmed");
		response.setRoomNo(roomNo);
		responseMap.put(roomNo, response);
		roomNo++;
		return response;
	}

	@Override
	public HotelBookingResponse getHotelById(Integer roomNo) {
		if(responseMap.containsKey(roomNo)) {
			return responseMap.get(roomNo);
		}
		throw new RoomNumberNotFoundException("roomNo Not found "+roomNo);
	}

	@Override
	public List<HotelBookingResponse> getAllHotelRooms() {
	
		return new ArrayList<>(responseMap.values());
	}

	@Override
	public void cancelRoom(Integer roomNo) {
		  if(responseMap.containsKey(roomNo)) {
	            responseMap.remove(roomNo);
	        } else {
	            throw new RoomNumberNotFoundException("roomNo Not found " + roomNo);
	        }
	    }

}
