package com.infina.likitech.exception;

public class FonStokCouldntAddException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6737550741775276636L;

	public FonStokCouldntAddException() {
		super("Fon Stok Eklenemedi!");
	}

	public FonStokCouldntAddException(String message) {
		super(message);
	}
	
	

}
