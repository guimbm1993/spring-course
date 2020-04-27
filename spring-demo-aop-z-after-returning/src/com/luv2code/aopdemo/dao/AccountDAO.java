package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	//add new method: findAccounts()
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		//create sample accounts
		Account temp1 = new Account("Jonh", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Lucca", "Gold");
		
		//add them to the list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + " DOING MY DB WORK AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println("doing work");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
	
}
