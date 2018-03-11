package com.epam.online.test.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class BaseDTO {
	
    private Date creationDate;

    private Date modifiedDate;
    
    private String createdBy;
    
    private String updatedBy;
    
    @ApiModelProperty(notes = "Creation Date of user", required = true)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

    @ApiModelProperty(notes = "Modification Date of user", required = true)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@ApiModelProperty(notes = "User created by", required = false)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@ApiModelProperty(notes = "User updated by", required = false)
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



}
