package com.neobank.spacemoney.service.impl;

import com.neobank.spacemoney.model.Transactions;
import com.neobank.spacemoney.service.PersistService;

public class TransactionServiceImpl implements PersistService<Transactions> {

	@Override
	public void create(Transactions c) {
		c.persist();
	}

}
