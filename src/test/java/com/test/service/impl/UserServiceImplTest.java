package com.test.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.MockitoAnnotations.initMocks;

import com.online.test.dao.entity.User;
import com.online.test.model.UserDTO;
import com.online.test.model.UserLoginDTO;
import com.online.test.repository.UserRepository;
import com.online.test.services.impl.UserServiceImpl;
import com.online.test.utils.PasswordUtility;
import com.test.config.AbstractServiceTestConfig;

/**
 * @author Anand Sadawarte.
 */
public class UserServiceImplTest extends AbstractServiceTestConfig{
	
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepo;
    
    @Before
    public void init() {
        initMocks(this);
      }
    
    @Test
    public void testSignUpUser() throws Exception {
    	UserDTO userDTO = new UserDTO();
    	userDTO.setFirstName("User");
    	userDTO.setLastName("lname");
    	userDTO.setUserName("uname");
    	userDTO.setPassword("password");
    	userService.signUpUser(userDTO);    	
    }
    
    @Test(expected = Exception.class)
    public void testSignUpUser_null() throws Exception {
    	
    	userService.signUpUser(null);    	
    }
    
    @Test(expected = Exception.class)
    public void testSignUpUser_UserName_null() throws Exception {
    	UserDTO userDTO = new UserDTO();
    	userDTO.setFirstName("User");
    	userDTO.setLastName("lname");
    	userDTO.setPassword("password");
    	userService.signUpUser(userDTO);    	
    }
    
    @Test(expected = Exception.class)
    public void testSignUpUser_FirstName_null() throws Exception {
    	UserDTO userDTO = new UserDTO();
    	userDTO.setUserName("uname");
    	userDTO.setLastName("lname");
    	userDTO.setPassword("password");
    	userService.signUpUser(userDTO);    	
    }
    
    @Test(expected = Exception.class)
    public void testSignUpUser_LastName_null() throws Exception {
    	UserDTO userDTO = new UserDTO();
    	userDTO.setFirstName("User");
    	userDTO.setUserName("uname");
    	userDTO.setPassword("password");
    	userService.signUpUser(userDTO);    	
    }
    
    @Test(expected = Exception.class)
    public void testSignUpUser_Password_null() throws Exception {
    	UserDTO userDTO = new UserDTO();
    	userDTO.setFirstName("User");
    	userDTO.setLastName("lname");
    	userService.signUpUser(userDTO);    	
    }
    
    @Test(expected = Exception.class)
    public void testLoginUser_userName_Password_Null() throws Exception {
    	UserLoginDTO user = new UserLoginDTO();
    	userService.login(user); 
    }
    
    @Test(expected = Exception.class)
    public void testLoginUser_userName_Null() throws Exception {
    	UserLoginDTO user = new UserLoginDTO();
    	user.setPassword("pwd");
    	userService.login(user); 
    }
    
    @Test(expected = Exception.class)
    public void testLoginUser_Password_Null() throws Exception {
    	UserLoginDTO user = new UserLoginDTO();
    	user.setUserName("user");
    	userService.login(user); 
    }
    
    @Test
    public void testLoginUser() throws Exception {
    	UserLoginDTO user = new UserLoginDTO();
    	user.setUserName("user1");
    	user.setPassword("pwd1");
    	String encryptedPwd = PasswordUtility.encryptPassword("pwd1");
    	User result = new User();
    	result.setUserName("user1");
    	result.setPassword(encryptedPwd);
    	Mockito.doReturn(result).when(userRepo).findOneByUserName("user1");
    	userService.login(user); 
    }
    
}
