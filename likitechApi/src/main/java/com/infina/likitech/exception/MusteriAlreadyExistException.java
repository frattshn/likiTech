package com.infina.likitech.exception;

public class MusteriAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7059276331505742085L;

	public MusteriAlreadyExistException() {
		super("Böyle bir müşteri zaten var!");
	}

	public MusteriAlreadyExistException(String message) {
		super(message);
	}

}
