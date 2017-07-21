package com.bankdb;

import java.util.HashMap;
import java.util.Map;

import com.bankingsystem.BankAccount;

/**
 * @author David
 * bankbd acts as a way to put data into memory for use of the API as opposed to
 * using an actual database. You can create more resources and services and pass
 * them through here using a HashMap. 
 */
public class BankDB {

	private static Map<Long, BankAccount> bankAccounts = new HashMap<>();
	
	public static Map<Long, BankAccount> getBankAccounts(){
		return bankAccounts;
	}
}
