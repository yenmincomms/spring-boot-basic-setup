package com.yenmin.proton.user.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yenmin.proton.user.dto.PaginationInfo;
import com.yenmin.proton.user.dto.SignUpRequest;
import com.yenmin.proton.user.dto.UserUpdateRequest;
import com.yenmin.proton.user.entity.User;
import com.yenmin.proton.user.messages.BaseResponse;
import com.yenmin.proton.user.messages.CustomMessage;
import com.yenmin.proton.user.repo.UserRepo;
import com.yenmin.proton.user.utils.Topic;

/**
 * Project Name : proton-user-service 
 * Created By : Sivakumar 
 * Created on : Sep 23, 2021 
 * ClassName : UserService.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 *
 * This software is the confidential and proprietary information of Yenmin
 * Technologies. India. (Confidential Information). You shall not disclose or
 * use Confidential Information without the express written agreement of Yenmin
 * Technologies India.
 * 
 */
@Service
@Transactional
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo userRepo;

	public BaseResponse signup(SignUpRequest signUpRequest) {
		try {
			User user = new User(signUpRequest);
			if (userRepo.existsByEmail(signUpRequest.getEmail())) {
				return new BaseResponse(Topic.USER.getName() + CustomMessage.ALREADY_EXIST_MESSAGE);
			}
			user.setCreatedDate(new Date());
			user.setFirstLogin(false);
			user.setStatus(false);
			userRepo.save(user);
		} catch (Exception ex) {
			LOGGER.error("Users Error {}", ex.getMessage());
		}
		return new BaseResponse(Topic.USER.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE);
	}

	public ResponseEntity<Object> getUserDetail(String id) {
		User adminDetails = userRepo.findById(id).orElseThrow(() -> new RuntimeException("details not found"));
		return ResponseEntity.ok(adminDetails);
	}

	public BaseResponse updateUser(UserUpdateRequest userUpdate) {
		User user = userRepo.findByEmail(userUpdate.getEmail());
		if(user == null) {
			return new BaseResponse(Topic.USER.getName() + CustomMessage.NO_RECOURD_FOUND);
		} else {
		user.setFirstName(userUpdate.getFirstName() != null ? userUpdate.getFirstName() : user.getFirstName());
		user.setLastName(userUpdate.getLastName() != null ? userUpdate.getLastName() : user.getLastName());
		user.setEmail(userUpdate.getEmail() != null ? userUpdate.getEmail() : user.getEmail());
		user.setAddress(userUpdate.getAddress() != null ? userUpdate.getAddress() : user.getAddress());
		user.setPassword(userUpdate.getPassword() != null ? userUpdate.getPassword() : user.getPassword());
		user.setDesignation(userUpdate.getDesignation() != null ? userUpdate.getDesignation() : user.getDesignation());
		user.setMobileNo(userUpdate.getMobileNo() != null ? userUpdate.getMobileNo() : user.getMobileNo());
		user.setLastModifiedDate(new Date());
		user.setStatus(true);
		userRepo.save(user);
		return new BaseResponse(Topic.USER.getName() + CustomMessage.UPDATE_SUCCESS_MESSAGE);
		}
	}

	public ResponseEntity<Object> getUserList(int page, int size) {
		Map<String, Object> userResponse = new LinkedHashMap<>();
		Pageable paging = PageRequest.of(page, size);
		Page<User> userList = userRepo.findByActive(true, paging);
		PaginationInfo info = new PaginationInfo();
		info.setTotalItems(userList.getTotalElements());
		info.setTotalPages(userList.getTotalPages());
		info.setCurrentPage(userList.getNumber());
		userResponse.put("userList", userList.getContent());
		userResponse.put("info", info);
		return ResponseEntity.ok(userResponse);
	}

	public BaseResponse deleteUserDetail(String id) {
		User userDetails = userRepo.findById(id).orElseThrow(() -> new RuntimeException("details not found"));
		userRepo.deleteById(userDetails.getId());
		return new BaseResponse(Topic.USER.getName() + CustomMessage.DELETE_SUCCESS_MESSAGE);
	}
}
