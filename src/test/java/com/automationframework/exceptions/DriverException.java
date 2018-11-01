package com.automationframework.exceptions;

public class DriverException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1303176369367159L;
	private static final String message = "Driver Verification exception: ";	
	
	public DriverException(){
		super();
	}
	
	public DriverException(String msg){
		super(message+" "+msg);
	}
	
	
	public DriverException (String msg,Throwable exp){
		super(message+" "+msg,exp);
	}
	 
	}
