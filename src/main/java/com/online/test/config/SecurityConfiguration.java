package com.online.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    private static String realName = "REALM";
    private final static String ROLE_ADMIN = "ADMIN";
    private final static String ROLE_USER = "USER";
    private final String uriPattern = "/oauth2/**";
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder authBuilder) throws Exception {
    	authBuilder.inMemoryAuthentication().withUser("admin").password("Admin@123").roles(ROLE_ADMIN);
    	authBuilder.inMemoryAuthentication().withUser("user").password("User@123").roles(ROLE_USER);
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.csrf().disable()
        .authorizeRequests()
        .antMatchers(this.uriPattern).hasAnyRole(ROLE_USER, ROLE_ADMIN)
        .and().httpBasic().realmName(realName).authenticationEntryPoint(this.getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
    }
     
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }
     
    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}