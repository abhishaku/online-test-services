package com.online.test.api.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Anand Sadawarte
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name="User.findByUserName", query="SELECT u FROM User u where u.userName = :userName") 
public class User extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role", nullable = true)
    private String role;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof User)){
            return false;
        }

        User other = (User)obj;
        Long ourId = getId();
        Long otherId = other.getId();
        if(ourId != null && otherId != null &&  ourId.equals(otherId)){
            return true;
        }

        return getUserName().equalsIgnoreCase(other.getUserName());
    }

    @Override
    public int hashCode(){
        return getId() == null ? Long.valueOf(0).hashCode() : getId().hashCode();
    }

}