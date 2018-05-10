package com.rest.model;

public class ResponseDTO {

	private Object return_object;
	private boolean status;
	private String message;
	public Object getReturn_object() {
		return return_object;
	}
	public void setReturn_object(Object return_object) {
		this.return_object = return_object;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
