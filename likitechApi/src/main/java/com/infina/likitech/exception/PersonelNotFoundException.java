package com.infina.likitech.exception;

public class PersonelNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8573029960897348801L;

	public Integer status;
	public Integer error;
	public String message;

	public PersonelNotFoundException() {
		super("Personel bulunamadı!");
	}

	public PersonelNotFoundException(String message) {
		super(message);
	}

	public PersonelNotFoundException(Integer status, Integer error, String message) {
		this.status = status;
		this.error = error;
		this.message = message;
	}

}