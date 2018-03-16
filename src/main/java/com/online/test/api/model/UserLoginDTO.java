package com.online.test.api.model;

import io.swagger.annotations.ApiModelProperty;

public class UserLoginDTO {
	
	 private String userName;
	 
	 private String password;

		@ApiModelProperty(notes = "Username of user", required = true)
	    public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}
		

	    @ApiModelProperty(notes = "Password of user", required = true)
	    public final String getPassword() {
	        return password;
	    }

	    public final void setPassword(final String password) {
	        this.password = password;
	    }


}
