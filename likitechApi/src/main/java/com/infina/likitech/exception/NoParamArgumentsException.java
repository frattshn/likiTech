package com.infina.likitech.exception;

public class NoParamArgumentsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3712279806495818575L;

	public NoParamArgumentsException() {
		super("Eksik parametre!");
	}

	public NoParamArgumentsException(String message) {
		super(message);
	}

}
