package com.infina.likitech.exception;

public class FonIslemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8657723377322667249L;

	public FonIslemNotFoundException() {
		super("Fon Islem Bulunamadı!");
	}

	public FonIslemNotFoundException(String message) {
		super(message);
	}

}
