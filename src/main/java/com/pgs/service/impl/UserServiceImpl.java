package com.pgs.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pgs.dao.entity.User;
import com.pgs.dto.UserDTO;
import com.pgs.dto.UserLoginDTO;
import com.pgs.exception.RequestException;
import com.pgs.repository.UserRepository;
import com.pgs.service.UserService;
import com.pgs.util.PasswordUtility;

/**
 * @author Anand Sadawarte 
 *
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepo;
    
	@Override
	public void signUpUser(UserDTO userDTO){

		if (userDTO == null) {
            throw new RequestException("Unable to process the create request as userDTO is null");
        }
		
		final String encryptedPassword;
        if(StringUtils.isEmpty(userDTO.getPassword())) { 
        	throw new RequestException("Password cannot be empty");
        }else {
        	encryptedPassword =PasswordUtility.encryptPassword(userDTO.getPassword());
        }

       
        final User user = buildUser(userDTO, encryptedPassword);
        userRepo.save(user);
	}
	
	
	@Override
	public void login(UserLoginDTO user){
		LOGGER.info("Login servier : User : " , user.getUserName());
		if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())){
			 throw new RequestException("Please provide the input");
		}
		User result = userRepo.findOneByUserName(user.getUserName());
		if(result == null) {
			throw new RequestException("Invalid User Name");
		}else if(!PasswordUtility.passwordMatch(user.getPassword(), result.getPassword())) {
			throw new RequestException("Invalid Password");
		}
	}
	
	private User buildUser(final UserDTO userDTO, final String password) {

        final Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
        
        final User user = new User();
        
        if(StringUtils.isEmpty(userDTO.getUserName())) { 
        	throw new RequestException("Username cannot be empty");
        }else {
        	User existing = userRepo.findOneByUserName(userDTO.getUserName());
        	if(existing != null) {
        		throw new RequestException("Username already exists");
        	}
        	user.setUserName(userDTO.getUserName());
        }
        
        if(StringUtils.isEmpty(userDTO.getFirstName())) { 
        	throw new RequestException("First name cannot be empty");
        }else {
        	user.setFirstName(userDTO.getFirstName());
        }
        
        if(StringUtils.isEmpty(userDTO.getLastName())) { 
        	throw new RequestException("Last name cannot be empty");
        }else {
        	user.setLastName(userDTO.getLastName());
        }
        
        user.setPassword(password);
        user.setRole("Admin");
        
        user.setCreationDate(currentDate);
        user.setModifiedDate(currentDate);
        user.setCreatedBy("user3");
        user.setUpdatedBy("user4");
        
        return user;
    }
    
}
