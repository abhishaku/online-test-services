package com.online.test.api.services;

import com.online.test.api.model.UserDTO;
import com.online.test.api.model.UserLoginDTO;

/**
 * @author Anand Sadawarte 
 *
 */
public interface UserService {
	
	void signUpUser(UserDTO user);

	void login(UserLoginDTO userLogin);
}
