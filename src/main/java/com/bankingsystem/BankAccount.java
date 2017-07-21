package com.bankingsystem;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "bankaccount") 

public class BankAccount{

	private long id;
	private String name;
	private int accountNumber;
	private int sortCode;
	
	public BankAccount(){
		
	}

	public BankAccount(long id, String name, int accountNumber, int sortCode) {
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getSortCode() {
		return sortCode;
	}

	   public void setSortCode(int sortCode) {
	      this.sortCode = sortCode;
	}
}
