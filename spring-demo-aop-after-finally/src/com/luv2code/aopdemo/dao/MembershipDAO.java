package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component // to support component scannong
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

	}
}
