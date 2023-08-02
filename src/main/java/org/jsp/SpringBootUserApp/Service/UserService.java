package org.jsp.SpringBootUserApp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserApp.Dao.UserDao;
import org.jsp.SpringBootUserApp.ResositoryHandler.IdNotFoundException;
import org.jsp.SpringBootUserApp.ResositoryHandler.InvalidCredensialException;
import org.jsp.SpringBootUserApp.dto.ResponseStructure;
import org.jsp.SpringBootUserApp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>>saveUser(User user) {
	 ResponseStructure<User> structure =new ResponseStructure<User>();
	 structure.setMessage("User Resistered");   
	 structure.setBody(dao.SaveUser(user));
	 structure.setCode(HttpStatus.CREATED.value());
	 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);	 
	}

	public ResponseEntity<ResponseStructure<User>> UpdateUser(User user) {
		 ResponseStructure<User> structure =new ResponseStructure<User>();
		 structure.setMessage("User Is Updated");
		 structure.setBody(dao.UpdateUser(user));
		 structure.setCode(HttpStatus.ACCEPTED.value());
		 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);	 
	}

	public ResponseEntity<ResponseStructure<User>> FindUser(int id) {
		 ResponseStructure<User> structure =new ResponseStructure<User>();
		Optional<User> recuser = dao.findUser(id);
		if (recuser.isPresent()) {
			structure.setMessage("User Found");
			structure.setBody(recuser.get());
			structure.setCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);	 
		}
		throw new IdNotFoundException();
	}

	

	public ResponseEntity<ResponseStructure<List<User>>> Findall() {
		 ResponseStructure<List<User>> structure =new ResponseStructure<List<User>>();
		 structure.setMessage("All User Found");
		 structure.setBody(dao.FindAll());
		 structure.setCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> DeleteUser(int id) {
		 ResponseStructure<String> structure =new ResponseStructure<String>();
		Optional<User> recUser = dao.findUser(id);
		if (recUser.isPresent()) {
  			structure.setBody("user Deleted");
			structure.setCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		
		structure.setMessage("User Not Found");
		structure.setBody("user NotDeleted");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> verifyemail(String email,String password)
	{
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> rec=dao.VerifyUser(email, password);
		if (rec.isPresent()) {
			structure.setMessage("Verify User By email And Password");
			structure.setBody(rec.get());
			structure.setCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);	 
		}
		throw new InvalidCredensialException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyPhone(long phone,String password)
	{
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> rec=dao.VerifyUser(phone, password);
		if (rec.isPresent()) {
			structure.setMessage("Verify User By phone And Password");
			structure.setBody(rec.get());
			structure.setCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);	 
		}
		throw new InvalidCredensialException();
	}
	}

