package com.proton.tracker.user.utils;

/**
 * Project Name : proton-user-service
 * Created By   : Sivakumar
 * Created on   : Sep 23, 2021
 * ClassName    : BaseResponse.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin Technologies. India.
 * (Confidential Information).  You shall not disclose or use Confidential
 * Information without the express written agreement of Yenmin Technologies India. 
 * 
 */
public class BaseResponse {

	private String message;

	public BaseResponse(String message) {
		this.message = message;
	}

	BaseResponse() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
