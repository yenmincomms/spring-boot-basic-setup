package com.proton.tracker.user.controller;

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

import com.proton.tracker.user.dto.SignUpRequest;
import com.proton.tracker.user.dto.UserUpdateRequest;
import com.proton.tracker.user.service.UserService;
import com.proton.tracker.user.utils.BaseResponse;

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
@RequestMapping("/proton/v2")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = { "/userCreate" })
	public ResponseEntity<BaseResponse> createOrUpdateEmployee(@RequestBody SignUpRequest signUpRequest) {
		BaseResponse response = userService.createUser(signUpRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/userUpdate")
	public ResponseEntity<BaseResponse> updateEmployee(@RequestBody UserUpdateRequest userUpdate) {
		BaseResponse response = userService.updateUser(userUpdate);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getUserList")
	public ResponseEntity<Object> userList(@RequestParam(defaultValue = "0", required = false) int page,
			@RequestParam(defaultValue = "10", required = false) int size) {
		return userService.getUserList(page, size);
	}

	@GetMapping("/getUserDetails/{id}")
	public ResponseEntity<Object> getUser(@PathVariable int id) {
		return userService.getUserDetail(id);
	}
	@DeleteMapping("/userDelete/{id}")
	public BaseResponse deleteUser(@PathVariable int id) {
		return userService.deleteUserDetail(id);
	}

}
