package com.proton.tracker.user.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proton.tracker.user.entity.User;

/**
 * Project Name : proton-user-service Created By : Sivakumar Created on : Sep
 * 23, 2021 ClassName : UserRepo.java
 *
 * Copyright (c) 2020 Yenmin Technologies. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yenmin
 * Technologies. India. (Confidential Information). You shall not disclose or
 * use Confidential Information without the express written agreement of Yenmin
 * Technologies India.
 * 
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

	User findByEmail(String email);

	Page<User> findByEmailActive(boolean b, Pageable paging);
	//Page<User> findAll( Pageable paging);

}
