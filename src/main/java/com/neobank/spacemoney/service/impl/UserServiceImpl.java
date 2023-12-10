package com.neobank.spacemoney.service.impl;

import com.neobank.spacemoney.model.Account;
import com.neobank.spacemoney.model.Transactions;
import com.neobank.spacemoney.model.User;
import com.neobank.spacemoney.service.AccountService;
import com.neobank.spacemoney.service.TransactionService;
import com.neobank.spacemoney.service.UserService;

public class UserServiceImpl implements UserService, AccountService, TransactionService {

	@Override
	public void createTransactions(Transactions transactions) {
		transactions.persist();
	}

	@Override
	public void createAccount(Account account) {
		account.persist();

	}

	@Override
	public void createUser(User user) {
		user.persist();
	}

}
