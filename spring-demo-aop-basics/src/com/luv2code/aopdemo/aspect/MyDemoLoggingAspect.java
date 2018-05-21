package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

/*	this is where we add all of our related advices for logging
	let's start with an @Before advice
 	**********************************
	Point cut expression - execution(public void addAccount())
	@Before("execution(public void addAccount())")
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	@Before("execution(public void add*())") //Using Wild-card pattern to match method name
	@Before("execution(void add*())") //return type matching using wild card.	
	************************************/	
	//@Before("execution(* add*(..))") // match on any parameters.
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // match on any methods within a particular package
 	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}










