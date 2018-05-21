package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String demo;
	private String serviceCode;


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
