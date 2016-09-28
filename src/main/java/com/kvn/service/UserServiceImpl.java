package com.kvn.service;

import com.kvn.dao.UserDao;
import com.kvn.entity.User;
import com.kvn.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySso(String sso) {
		return dao.findBySSO(sso);
	}

	public void addUser(User user) {
		user.setSsoId(Utility.generateSso(user.getEmail()));
		user.setState("1");
		dao.save(user);
	}



}
