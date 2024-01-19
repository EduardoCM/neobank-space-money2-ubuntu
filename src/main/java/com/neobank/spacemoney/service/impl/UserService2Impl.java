package com.neobank.spacemoney.service.impl;

import com.neobank.spacemoney.model.User;
import com.neobank.spacemoney.service.PersistService;

public class UserService2Impl implements PersistService<User> {

	@Override
	public void create(User u) {
		u.persist();
	}

	@Override
	public User findById(Integer id) {
		User user = User.findById(id);
		
		System.out.println("Usuarioooooo: " + user);
		
		return user;
	}

}
