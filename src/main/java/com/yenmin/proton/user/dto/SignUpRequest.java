package com.yenmin.proton.user.dto;




import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Field;

import com.yenmin.proton.user.utils.Password;

import lombok.Data;

/**
 * Project Name : proton-user-service
 * Created By   : Sivakumar
 * Created on   : Sep 23, 2021
 * ClassName    : SignUpRequest.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin Technologies. India.
 * (Confidential Information).  You shall not disclose or use Confidential
 * Information without the express written agreement of Yenmin Technologies India. 
 * 
 */
@Data
public class SignUpRequest {
	private String oid;
	@Field("emp_id")
	private String empId;
	@NotBlank(message = "firstName:must not be blank")
	@Size(min = 3)
	private String firstName;
	@Size(min = 1, message = "firstName:must not be blank")
	private String lastName;
	@NotNull(message = "email:must not be blank or null")
	@Email
	private String email;
	private String designation;
	@Field("join_date")
	private String joinDate;
	private String dob;
	private String role;
	private String address;
	private String mobileNo;
	private String[] team;
	private String profile;
	@Password(message = "password:1 Special character and length minimum 8 ")
	private String password;
	@NotBlank(message = "confirmpassword:must not be blank or null")
	private String confirmPassword;
	private Object meta;
	private Object setting;

}
