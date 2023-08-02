package org.jsp.SpringBootUserApp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserApp.Repository.UserRepository;
import org.jsp.SpringBootUserApp.Service.UserService;
import org.jsp.SpringBootUserApp.dto.ResponseStructure;
import org.jsp.SpringBootUserApp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}

	@PutMapping("/users") 
	public ResponseEntity<ResponseStructure<User>> UpdateUser(@RequestBody User user) 
	{
		return service.UpdateUser(user);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> FindUserByid(@PathVariable int id) {
		return service.FindUser(id);
	}

	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> FetchAll() {
		return service.Findall();
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.DeleteUser(id);
	}    
	@PostMapping("/users/verify-phone")
	public ResponseEntity<ResponseStructure<User>> verifyByphone(@RequestParam long phone ,@RequestParam  String password) {
		return service.verifyPhone(phone, password);
	}
	@PostMapping("/users/verify-email")
	public ResponseEntity<ResponseStructure<User>> verifyByemail(@RequestParam String email ,@RequestParam  String password) {
		return service.verifyemail(email, password);
	}
}
