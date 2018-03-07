package com.epam.online.test.dto;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author Anand Sadawarte 
 * 
 */
public class UserDTO {

	private Long userId;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String role;


    @ApiModelProperty(notes = "Role of user", required = true)
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ApiModelProperty(notes = "Username of user", required = true)
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ApiModelProperty(notes = "UserId of user", required = true)
	public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    @ApiModelProperty(notes = "First name of user", required = true)
    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @ApiModelProperty(notes = "Last name of user", required = true)
    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @ApiModelProperty(notes = "Password of user", required = true)
    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

	@Override
    public String toString() {
        return "UserName='" + userName + '\''
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\'';
    }
}
