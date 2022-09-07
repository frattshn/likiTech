package com.infina.likitech.exception;

public class HesapNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9205548609423778123L;

	public HesapNotFoundException() {
		super("Hesap bulunamadı!");
	}

	public HesapNotFoundException(String message) {
		super(message);
	}
	
	

}
