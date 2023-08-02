package org.jsp.SpringBootUserApp.dto;

public class ResponseStructure<T> {
	private String message;
	private T Body;
	private int code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return Body;
	}

	public void setBody(T body) {
		Body = body;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
