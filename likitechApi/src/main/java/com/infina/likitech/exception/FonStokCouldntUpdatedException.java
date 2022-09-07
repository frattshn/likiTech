package com.infina.likitech.exception;

public class FonStokCouldntUpdatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -13021351064894664L;

	public FonStokCouldntUpdatedException() {
		super("Fon Stok Güncellenemedi!");
	}

	public FonStokCouldntUpdatedException(String message) {
		super(message);
	}
	
	

}
