package com.epam.online.test.services;

import com.epam.online.test.dto.UserDTO;
import com.epam.online.test.dto.UserLoginDTO;

/**
 * @author Anand Sadawarte 
 *
 */
public interface UserService {
	
	void signUpUser(UserDTO user);

	void login(UserLoginDTO userLogin);
}
