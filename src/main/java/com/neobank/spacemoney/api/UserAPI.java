package com.neobank.spacemoney.api;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.neobank.spacemoney.model.Account;
import com.neobank.spacemoney.model.Operation;
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
	
	@GET
	@Path("/{id}")
	public Response getUser(@PathParam("id") Integer id) {
		log.info("GET BY ID 2 ::::::::" + id);
		 User resultado = userService.findById(id);
		log.info("Usuario:::: " + resultado);
		return Response.status(Status.ACCEPTED).entity(resultado).build();
	}
	
	

	@POST
	@Path("/account")
	public Response createAccount(Account account) {

		log.info("Programacion generica: " + account);
		
		User userAccount = userService.findById(account.userId);
		
		if(userAccount == null) {
			return Response.status(Status.BAD_REQUEST).entity("No existe usuario para el que se desea crear esta cuenta").build();
		} else {			
			accountService.create(account);
			return Response.status(Status.CREATED).build();
		}
	}
	
	
	@GET
	@Path("/account/{id}")
	public Response getAccount(@PathParam("id") Integer id) {
		log.info("GET BY ID 2 ::::::::" + id);	
		Account account = accountService.findById(id);
		return Response.status(Status.ACCEPTED).entity(account).build();
	}

	@POST
	@Path("/transaction")
	public Response createTransaction(Transactions transaction) {
		log.info("Programacion generica: " + transaction);
		
		Account account = accountService.findById(transaction.accountId);
		
		if(account == null) {
			return Response.status(Status.BAD_REQUEST).entity("No existe cuenta con la que se intenta hacer la transacción").build();
		}
		
		if(transaction.operation.equals(Operation.RETIRO) && transaction.amount > account.balance) {
			return Response.status(Status.BAD_REQUEST).entity("No cuentas con el saldo suficiente").build();
		}
		
		if(transaction.operation.equals(Operation.RETIRO)) {
			account.balance = account.balance -  transaction.amount;
			accountService.create(account);
		}
		
		transactionService.create(transaction);
		
		return Response.status(Status.CREATED).build();
	}

}
