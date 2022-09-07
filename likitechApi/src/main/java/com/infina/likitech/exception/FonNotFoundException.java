package com.infina.likitech.exception;

public class FonNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6026472730706103502L;

	public Integer status;

	public FonNotFoundException() {
		super("Fon Bulunamadı!");
	}

	public FonNotFoundException(String message) {
		super(message);
	}

	public FonNotFoundException(Integer status) {
		this.status = status;
	}

}
