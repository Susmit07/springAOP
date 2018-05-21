package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String demo;
	private String serviceCode;

	// Add new method : findAccounts()
	public List<Account> findAccounts(boolean setFlag){
		
		// Forcibly generating exception
		if(setFlag == true) {
			throw new RuntimeException("Flag set to be true for exception!!");
		}
		List<Account> myAccount = new ArrayList<>();
		Account acc1 = new Account("Akash", 1234);
		Account acc2 = new Account("Sayan", 12378);
		myAccount.add(acc1);
		myAccount.add(acc2);
		return myAccount;
	}
	
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public void dowork() {
		System.out.println(getClass()+ ": DOING MY ACCOUNT WORK");
	}

	public String getDemo() {
		System.out.println(getClass()+ " in getDemo()");
		return demo;
	}

	public void setDemo(String demo) {
		System.out.println(getClass()+ " in setDemo()");
		this.demo = demo;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ " in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ " in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
