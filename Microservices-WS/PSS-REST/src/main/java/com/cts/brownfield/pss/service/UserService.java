package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.User;

public interface UserService {
	
	User findByUserNameAndPassword(String userName, String password);
	boolean existsByUserNameAndPassword(String userName, String password);
	User findById(String userName);
	User save(User user);
}
