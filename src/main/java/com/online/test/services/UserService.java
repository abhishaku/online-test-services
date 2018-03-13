package com.online.test.services;

import com.online.test.model.UserDTO;
import com.online.test.model.UserLoginDTO;

/**
 * @author Anand Sadawarte 
 *
 */
public interface UserService {
	
	void signUpUser(UserDTO user);

	void login(UserLoginDTO userLogin);
}
