package com.infina.likitech.exception;

public class FonCouldntUpdatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2871012832573093729L;

	public FonCouldntUpdatedException() {
		super("Fon Güncellenemedi!");
	}

	public FonCouldntUpdatedException(String message) {
		super(message);
	}

}
