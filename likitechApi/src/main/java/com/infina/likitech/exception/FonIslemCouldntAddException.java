package com.infina.likitech.exception;

public class FonIslemCouldntAddException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6046759749399360655L;

	public FonIslemCouldntAddException() {
		super("Fon Islem Eklenemedi!");
	}

	public FonIslemCouldntAddException(String message) {
		super(message);
	}

}
