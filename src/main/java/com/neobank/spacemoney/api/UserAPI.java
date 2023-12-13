package com.neobank.spacemoney.api;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.neobank.spacemoney.model.Account;
import com.neobank.spacemoney.model.Transactions;
import com.neobank.spacemoney.model.User;
import com.neobank.spacemoney.service.PersistService;
import com.neobank.spacemoney.service.impl.AccountServiceImpl;
import com.neobank.spacemoney.service.impl.TransactionServiceImpl;
import com.neobank.spacemoney.service.impl.UserService2Impl;

@Path("/api/user")
@Transactional
public class UserAPI {

	@Inject
	private Logger log;

	private PersistService<User> userService = new UserService2Impl();

	private PersistService<Account> accountService = new AccountServiceImpl();

	private PersistService<Transactions> transactionService = new TransactionServiceImpl();

	@POST
	public Response createUser(User user) {

		log.info("Programacion generica: " + user);

		userService.create(user);

		return Response.status(Status.CREATED).build();
	}

	@POST
	@Path("/account")
	public Response createAccount(Account account) {

		log.info("Programacion generica: " + account);

		accountService.create(account);

		return Response.status(Status.CREATED).build();
	}

	@POST
	@Path("/transaction")
	public Response createTransaction(Transactions transaction) {

		log.info("Programacion generica: " + transaction);

		transactionService.create(transaction);

		return Response.status(Status.CREATED).build();
	}

}
