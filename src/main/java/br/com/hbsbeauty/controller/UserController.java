package br.com.hbsbeauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hbsbeauty.model.User;
import br.com.hbsbeauty.services.UserServices;

@RestController
public class UserController {
	@Autowired
	private UserServices userServices;
	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List <User>> getAllUsers(){
		List <User> user = userServices.getAllUsers();
		return new ResponseEntity <>(user, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User>getUserById(@PathVariable Integer id){
		User user = userServices.getUsersById(id);
		return new ResponseEntity(user, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User>saveUser(@RequestBody User user){
		return new ResponseEntity(userServices.saveOrUpdateUser(user), HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User>updateUser(@RequestBody User user){
		return new ResponseEntity(userServices.saveOrUpdateUser(user), HttpStatus.CREATED);
	}
		
	@DeleteMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUser(@PathVariable Integer id){
		 return userServices.deleteUser(id);
	}
		
	
}
