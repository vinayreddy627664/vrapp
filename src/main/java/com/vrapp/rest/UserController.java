package com.vrapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrapp.domain.User;
import com.vrapp.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<User> create(@RequestBody User user) throws Exception {
			return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
		}
		
		
		

		
}
