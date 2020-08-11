package com.cts.brownfield.pss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.brownfield.pss.entity.User;

public interface UserDao extends JpaRepository<User, String> {

	User findByUserNameAndPassword(String userName, String password);
	boolean existsByUserNameAndPassword(String userName, String password);


}
