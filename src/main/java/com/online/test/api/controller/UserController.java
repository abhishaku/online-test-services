package com.online.test.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.test.api.model.UserDTO;
import com.online.test.api.model.UserLoginDTO;
import com.online.test.api.services.UserService;
import com.online.test.api.services.response.UserResponse;

/**
 * @author Anand Sadawarte
 *
 */
@RestController
@RequestMapping("/api/auth/v1/user")
public class UserController {

	/**
	 * LOGGER for the class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> signUpUser(@RequestBody final UserDTO user) {
		LOGGER.debug("Received request for create admin user {}", user);
		userService.signUpUser(user);
		UserResponse resp = new UserResponse();
		resp.setSuccess(true);
		resp.setMessage("User created successfully");
		return new ResponseEntity<>(resp,HttpStatus.OK);
	} 
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> loginUser(@RequestBody final UserLoginDTO userLogin) {
		LOGGER.info("Received request for user login {}", userLogin);
			userService.login(userLogin);
			LOGGER.debug("End user login ::");
			UserResponse resp = new UserResponse();
			resp.setSuccess(true);
			resp.setMessage("User login successful");
			return new ResponseEntity<>(resp,HttpStatus.OK);
			
	} 

}
