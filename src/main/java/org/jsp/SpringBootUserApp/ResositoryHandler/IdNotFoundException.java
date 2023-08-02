package org.jsp.SpringBootUserApp.ResositoryHandler;

public class IdNotFoundException extends RuntimeException{
	public String getmessage() {
		return "Invalid Id";
	}

}
