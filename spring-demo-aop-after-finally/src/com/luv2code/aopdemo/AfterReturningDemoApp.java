package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = theAccountDAO.findAccounts(false);
		System.out.println("\n");
		System.out.println("Executing main Program =====> AfterReeturningDemoApp");
		System.out.println("Accounts: "+accounts);
				
		// close the context
		context.close();
	}

}










