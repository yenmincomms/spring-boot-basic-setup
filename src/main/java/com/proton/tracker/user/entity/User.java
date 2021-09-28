package com.proton.tracker.user.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.proton.tracker.user.dto.SignUpRequest;

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
@Entity
@Table(name = "pt_users",
indexes = {@Index(columnList = "email", unique = true, name = "email")}
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "password", "lastModifiedBy", "lastModifiedDate", "createdBy", "createdDate" })
public class User {

	@Transient
	public static final String SEQUENCE_NAME = "employee_sequence";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@Column(name = "oid")
//	private String oid;
	@Column(name = "first_name")
	@Size(min = 3)
	private String firstName;
	@Size(max = 15)
	@Column(name = "last_name")
	private String lastName;
	@Email
	@NotBlank
	@Column(name = "email")
	private String email;
	@Column(name = "designation")
	private String designation;
	@Column(name = "join_date")
	private Date joinDate;
	@Column(name = "dob")
	private Date dob;
	//private Object role;
	@Column(name = "address")
	@Size(min = 3, max = 100)
	private String address;
	@Column(name = "profile")
	private String profile;
	@Column(name = "user_status")
	private boolean userStatus;
	@Column(name = "password")
	private String password;
	@Column(name = "last_login")
	private Date lastLogin;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name="last_modified_by")
	private String lastModifiedBy;
	@Column(name="last_modified_date",insertable =  false)
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date lastModifiedDate;
	@Column(name="created_by")
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date", updatable = false)
	private Date createdDate;
	private boolean emailActive = true;

	public User(SignUpRequest signUpRequest) {
		this.firstName = signUpRequest.getFirstName();
		this.lastName = signUpRequest.getLastName();
		this.email = signUpRequest.getEmail();
		this.password = signUpRequest.getPassword();
		this.address = signUpRequest.getAddress();
		this.designation = signUpRequest.getDesignation();
		this.mobileNo = signUpRequest.getMobileNo();
	}

	public User() {
		super();
	}
}
