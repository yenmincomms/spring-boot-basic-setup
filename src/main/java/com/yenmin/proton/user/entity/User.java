package com.yenmin.proton.user.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yenmin.proton.user.dto.SignUpRequest;

import lombok.Data;

/**
 * Project Name : proton-user-service Created By : Sivakumar Created on : Sep
 * 23, 2021 ClassName : User.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin
 * Technologies. India. (Confidential Information). You shall not disclose or
 * use Confidential Information without the express written agreement of Yenmin
 * Technologies India.
 * 
 */
@Data
@Document(collection = "pt_users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "password", "lastModifiedBy", "lastModifiedDate", "createdBy", "createdDate" })

public class User {

	@Transient
	public static final String SEQUENCE_NAME = "employee_sequence";

	@Id
	private String id;
	private String oid;
	@Field("emp_id")
	private String empId;
	@Size(min = 3)
	private String firstName;
	@Size(max = 15)
	private String lastName;
	@Email
	@NotBlank
	private String email;
	private String designation;
	@Field("join_date")
	private Date joinDate;
	private Date dob;
	private Object role;
	@Size(min = 3, max = 100)
	private String address;
	// private Listt<Team> team;
	private String profile;
	private boolean status;
	private boolean firstLogin;
	private String password;
	private String confirmPassword;
	private Date lastLogin;
	private Object meta;
	private Object setting;
	private String mobileNo;
	@Field("last_modified_by")
	private String lastModifiedBy;
	@Field("last_modified_date")
	private Date lastModifiedDate;
	@Field("created_by")
	private String createdBy;
	@Field("created_date")
	private Date createdDate;
	private String otp;
	private String token;
	private LocalDateTime tokenCreationDate;
	private Date activities;
	private boolean active = true;

	public User(SignUpRequest signUpRequest) {
		this.firstName = signUpRequest.getFirstName();
		this.lastName = signUpRequest.getLastName();
		this.email = signUpRequest.getEmail();
		this.password = signUpRequest.getPassword();
		this.confirmPassword = signUpRequest.getConfirmPassword();
		this.address = signUpRequest.getAddress();
		this.designation = signUpRequest.getDesignation();
		this.mobileNo = signUpRequest.getMobileNo();
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
