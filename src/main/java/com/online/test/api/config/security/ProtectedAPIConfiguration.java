package com.online.test.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
 
@Configuration
@EnableWebSecurity
@Order(1) //this is when multiple security configuration classes are defined.
public class ProtectedAPIConfiguration extends WebSecurityConfigurerAdapter {
 
    public static String realName = "api-security";
    private final static String ROLE_ADMIN = "ADMIN";
    private final static String ROLE_USER = "USER";
    private final String protectedEndpointPattern = "/auth/**";
    
    @Value("${data.user.id}")
    private String username;
    
    @Value("${data.user.password}")
    private String password;
    
    @Autowired
    private CustomBasicAuthenticationEntryPoint authEntryPoint;
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder authBuilder) throws Exception {
    	authBuilder.inMemoryAuthentication().withUser(this.username).password(this.password).roles(ROLE_USER);
    	/*	Multiple users can be added this way.
    		authBuilder.inMemoryAuthentication().withUser("admin").password("Admin@123").roles(ROLE_ADMIN);
    		authBuilder.inMemoryAuthentication().withUser("user").password("User@123").roles(ROLE_USER);    	 
    	*/
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {   	
    	http.csrf().disable()
    	.authorizeRequests()
    	.antMatchers(this.protectedEndpointPattern).hasAnyRole(ROLE_USER, ROLE_ADMIN)
		.and().httpBasic().realmName(realName).authenticationEntryPoint(this.authEntryPoint)
    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.    	  
    }
}