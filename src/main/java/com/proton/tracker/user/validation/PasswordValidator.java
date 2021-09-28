package com.proton.tracker.user.validation;

/**
 * Project Name : proton-user-service
 * Created By   : Sivakumar
 * Created on   : Sep 23, 2021
 * ClassName    : PasswordValidator.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin Technologies. India.
 * (Confidential Information).  You shall not disclose or use Confidential
 * Information without the express written agreement of Yenmin Technologies India. 
 * 
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator class for custom validation annotation known as NullOrNotBlank to
 * validate only blank space.
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

	public void initialize(Password parameters) {

	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		return value.trim().length() > 0 && passwordValidator(value);
	}

	public boolean passwordValidator(String value) {
		char a[] = value.toCharArray();
		if (a.length < 7) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!Character.isAlphabetic(a[i])) {
				System.out.println("In ");
				return true;
			}

		}
		return false;

	}
}
