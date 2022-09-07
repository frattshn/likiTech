package com.infina.likitech.exception;

public class FonFiyatCouldntUpdated extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8179066882773994543L;

	public FonFiyatCouldntUpdated() {
		super("Fon Fiyat güncellenemedi!");
	}

	public FonFiyatCouldntUpdated(String message) {
		super(message);
	}

}
