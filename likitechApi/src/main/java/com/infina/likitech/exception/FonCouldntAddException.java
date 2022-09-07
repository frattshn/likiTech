package com.infina.likitech.exception;

public class FonCouldntAddException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2762301900682041311L;

	public FonCouldntAddException() {
		super("Fon Eklenemedi!");
	}

	public FonCouldntAddException(String message) {
		super(message);
	}

}
