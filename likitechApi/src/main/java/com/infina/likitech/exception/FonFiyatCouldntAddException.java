package com.infina.likitech.exception;

public class FonFiyatCouldntAddException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6070991965278164312L;

	public FonFiyatCouldntAddException() {
		super("Fon Fiyat eklenemedi!");
	}

	public FonFiyatCouldntAddException(String message) {
		super(message);
	}

}
