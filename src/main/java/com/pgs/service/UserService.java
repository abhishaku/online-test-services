package com.pgs.service;

import com.pgs.dto.UserDTO;
import com.pgs.dto.UserLoginDTO;

/**
 * @author Anand Sadawarte 
 *
 */
public interface UserService {
	
	void signUpUser(UserDTO user);

	void login(UserLoginDTO userLogin);
}
