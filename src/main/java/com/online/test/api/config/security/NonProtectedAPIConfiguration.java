package com.online.test.api.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
 
@Configuration
@EnableWebSecurity
@Order(2)
public class NonProtectedAPIConfiguration extends WebSecurityConfigurerAdapter {
 
	private final String nonProtectedEndpointPattern = "/guest/**";
        
    @Override
    protected void configure(HttpSecurity http) throws Exception {   	
    	http.antMatcher(this.nonProtectedEndpointPattern)
    	.authorizeRequests().anyRequest().permitAll()
    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);    	
    }
}