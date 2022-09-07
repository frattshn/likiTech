package com.infina.likitech.exception;

public class MusteriNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -562225715820058848L;

	public MusteriNotFoundException() {
		super("Musteri bulunamadi!");
	}

	public MusteriNotFoundException(String message) {
		super(message);
	}
	
	

}
