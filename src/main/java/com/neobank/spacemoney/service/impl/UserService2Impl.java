package com.neobank.spacemoney.service.impl;

import com.neobank.spacemoney.model.User;
import com.neobank.spacemoney.service.PersistService;

public class UserService2Impl implements PersistService<User> {

	@Override
	public void create(User u) {
		u.persist();
	}

}
