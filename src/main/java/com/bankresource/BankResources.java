package com.bankresource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bankingsystem.BankAccount;
import com.bankservices.BankAccountService;

@Path("/bankaccount")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankResources {

	BankAccountService bankService = new BankAccountService();

	@GET
	public List<BankAccount> getBankAccounts() {
		return bankService.getAllBankAccounts();
	}

	@POST
	public BankAccount addBankAccount(BankAccount bankaccount) {
		return bankService.addBankAccount(bankaccount);
	}
	
	@PUT
	@Path("/{accountId}")
	public BankAccount updateBankAccount(@PathParam("accountId") long id, BankAccount bankaccount) {
		bankaccount.setId(id);
		return bankService.updateBankAccount(bankaccount);
	}
	
	@DELETE
	@Path("/{accountId}")
	public BankAccount deleteBankAccount(@PathParam("accountId") long id) {
		return bankService.removeBankAccount(id);
	}
	
	@GET
	@Path("/{accountId}")
	public BankAccount getBankAccount(@PathParam("accountId") long id) {
		return bankService.getBankAccount(id);
	}
}
