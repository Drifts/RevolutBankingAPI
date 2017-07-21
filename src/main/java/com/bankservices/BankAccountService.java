package com.bankservices;

import java.util.List;
import java.util.Map;

import com.bankdb.BankDB;
import com.bankingsystem.BankAccount;

import java.util.ArrayList;

/**
 * @author David This source code handles the calculations for actions executed
 *         for a bank account. It also provides the initial details for each
 *         bank account.
 */
public class BankAccountService {

	private Map<Long, BankAccount> bankAccounts = BankDB.getBankAccounts();

	public BankAccountService() {
		bankAccounts.put(1L, new BankAccount(1,"John Smith", 12345678, 111111));
		bankAccounts.put(2L, new BankAccount(2, "Peter Park", 12345679, 111111));
	}
	
	public List<BankAccount> getAllBankAccounts() {
		return new ArrayList<BankAccount>(bankAccounts.values());
	}

	public BankAccount getBankAccount(long id) {
		return bankAccounts.get(id);
	}

	public BankAccount addBankAccount(BankAccount bankaccount) {
		bankaccount.setId(bankAccounts.size() + 1);
		bankAccounts.put(bankaccount.getId(), bankaccount);
		return bankaccount;
	}

	public BankAccount updateBankAccount(BankAccount bankaccount) {
		if (bankaccount.getId() <= 0) {
			return null;
		}
		bankAccounts.put(bankaccount.getId(), bankaccount);
		return bankaccount;
	}

	public BankAccount removeBankAccount(long id) {
		return bankAccounts.remove(id);
	}
}
