package com.neobank.spacemoney.service.impl;

import com.neobank.spacemoney.model.Account;
import com.neobank.spacemoney.service.PersistService;

public class AccountServiceImpl implements PersistService<Account> {

	@Override
	public void create(Account a) {
		a.persist();
	}

}
