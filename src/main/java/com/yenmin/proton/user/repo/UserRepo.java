package com.yenmin.proton.user.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yenmin.proton.user.entity.User;

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
public interface UserRepo extends MongoRepository<User, String> {

	boolean existsByEmail(String email);

	User findByEmail(String email);

	Page<User> findByActive(boolean b, Pageable paging);

}
