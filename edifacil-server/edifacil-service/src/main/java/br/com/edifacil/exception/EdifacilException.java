package br.com.edifacil.exception;

public class EdifacilException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EdifacilException(){
		super();
	}
	
	public EdifacilException(String message){
		super(message);
	}
}