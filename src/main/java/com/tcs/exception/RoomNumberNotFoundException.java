package com.tcs.exception;

public class RoomNumberNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public RoomNumberNotFoundException(String msg) {
		super(msg);
	}

}
