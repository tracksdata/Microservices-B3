package com.cts.brownfield.pss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.UserDao;
import com.cts.brownfield.pss.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.findByUserNameAndPassword(userName, password);
	}

	@Override
	public boolean existsByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.existsByUserNameAndPassword(userName, password);
	}

	@Override
	public User findById(String userName) {
		// TODO Auto-generated method stub
		return userDao.findById(userName).orElse(null);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
