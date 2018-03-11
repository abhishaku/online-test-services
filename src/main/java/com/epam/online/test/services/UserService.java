package com.epam.online.test.services;

import com.epam.online.test.model.UserDTO;
import com.epam.online.test.model.UserLoginDTO;

/**
 * @author Anand Sadawarte 
 *
 */
public interface UserService {
	
	void signUpUser(UserDTO user);

	void login(UserLoginDTO userLogin);
}
