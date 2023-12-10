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
import com.neobank.spacemoney.service.AccountService;
import com.neobank.spacemoney.service.TransactionService;
import com.neobank.spacemoney.service.UserService;
import com.neobank.spacemoney.service.impl.UserServiceImpl;

@Path("/api/user")
@Transactional
public class UserAPI {

	@Inject
	private Logger log;

	private UserService userService = new UserServiceImpl();

	private AccountService accountService = new UserServiceImpl();

	private TransactionService transactionService = new UserServiceImpl();

	@POST
	public Response createUser(User user) {
		log.info("Create user: " + user);
		userService.createUser(user);
		return Response.status(Status.CREATED).build();
	}

	@POST
	@Path("/account")
	public Response createAccount(Account account) {
		log.info("Create account: " + account);
		accountService.createAccount(account);
		return Response.status(Status.CREATED).build();
	}

	@POST
	@Path("/transaction")
	public Response createTransaction(Transactions transaction) {
		log.info("Create transaction: " + transaction);
		transactionService.createTransactions(transaction);
		return Response.status(Status.CREATED).build();
	}

}
