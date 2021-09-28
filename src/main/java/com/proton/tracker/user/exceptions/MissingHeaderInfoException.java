package com.proton.tracker.user.exceptions;
/**
 * Project Name : proton-user-service
 * Created By   : Sivakumar
 * Created on   : Sep 23, 2021
 * ClassName    : MissingHeaderInfoException.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin Technologies. India.
 * (Confidential Information).  You shall not disclose or use Confidential
 * Information without the express written agreement of Yenmin Technologies India. 
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingHeaderInfoException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public MissingHeaderInfoException(String message) {
        super(message);
    }
}
