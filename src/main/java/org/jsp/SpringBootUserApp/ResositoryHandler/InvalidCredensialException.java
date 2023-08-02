package org.jsp.SpringBootUserApp.ResositoryHandler;

public class InvalidCredensialException extends RuntimeException{
	public String getMessage() {
	return "Invalid phone or Email or password ";
}
}
