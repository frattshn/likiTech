package com.infina.likitech.exception;

public class HesapDtoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -234336489802084221L;

	public HesapDtoNotFoundException() {
		super("HesapDto bulunamad─▒!");
	}

	public HesapDtoNotFoundException(String message) {
		super(message);
	}
	
	

}
