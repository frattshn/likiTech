package com.infina.likitech.exception;

public class FonFiyatNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4864802869832280946L;

	public FonFiyatNotFoundException() {
		super("Fon Fiyat bulunamadı!");
	}

	public FonFiyatNotFoundException(String message) {
		super(message);
	}

}
