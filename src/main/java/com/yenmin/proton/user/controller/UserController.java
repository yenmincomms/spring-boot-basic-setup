package com.yenmin.proton.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yenmin.proton.user.dto.SignUpRequest;
import com.yenmin.proton.user.dto.UserUpdateRequest;
import com.yenmin.proton.user.messages.BaseResponse;
import com.yenmin.proton.user.service.UserService;

/**
 * Project Name : proton-user-service Created By : Sivakumar Created on : Sep
 * 23, 2021 ClassName : UserController.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin
 * Technologies. India. (Confidential Information). You shall not disclose or
 * use Confidential Information without the express written agreement of Yenmin
 * Technologies India.
 * 
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = { "/signup" })
	public ResponseEntity<BaseResponse> createUser(@RequestBody SignUpRequest signUpRequest) {
		BaseResponse response = userService.createUser(signUpRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/update-user")
	public ResponseEntity<BaseResponse> updateUser(@RequestBody UserUpdateRequest userUpdate) {
		BaseResponse response = userService.updateUser(userUpdate);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/user-list")
	public ResponseEntity<Object> userList(@RequestParam(defaultValue = "0", required = false) int page,
			@RequestParam(defaultValue = "10", required = false) int size) {
		return userService.userList(page, size);
	}

	@GetMapping("/user-detail/{id}")
	public ResponseEntity<Object> userDetail(@PathVariable String id) {
		return userService.userDetail(id);
	}

	@DeleteMapping("/user-delete/{id}")
	public BaseResponse deleteUser(@PathVariable String id) {
		return userService.deleteUser(id);
	}

}
