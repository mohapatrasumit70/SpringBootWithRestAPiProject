package org.jsp.SpringBootUserApp.ResositoryHandler;

import org.jsp.SpringBootUserApp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class UserBootAppExceptionHandle extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> HandleIdNotFoundException(IdNotFoundException e){
	ResponseStructure<String > structure = new ResponseStructure<>();
	structure.setBody("user not found");
	structure.setMessage(e.getmessage());
	structure.setCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);	
}
	@ExceptionHandler(InvalidCredensialException.class)
public ResponseEntity<ResponseStructure<String>> HandleInvalidCredensial(InvalidCredensialException e){
	ResponseStructure<String > structure = new ResponseStructure<>();
	structure.setBody("user not found");
	structure.setMessage(e.getMessage());
	structure.setCode(HttpStatus.NOT_FOUND.value());;
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);	
}
}
