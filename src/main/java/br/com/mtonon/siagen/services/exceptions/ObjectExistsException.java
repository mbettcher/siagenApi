package br.com.mtonon.siagen.services.exceptions;

public class ObjectExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectExistsException(String msg) {
		super(msg);
	}
	
	public ObjectExistsException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
