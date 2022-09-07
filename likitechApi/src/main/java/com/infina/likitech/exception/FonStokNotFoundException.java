package com.infina.likitech.exception;

public class FonStokNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7731735527234341066L;

	public FonStokNotFoundException() {
		super("Fon Stok Bulunamadı!");
	}

	public FonStokNotFoundException(String message) {
		super(message);
	}

}
