package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*this is where we add all of our related advice for logging
	let's start with an @Before advice
	 ***********************************/
	
	//Creating point-cut declaration.
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//create point-cut for setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forGetter() {}
	
	//create point-cut for getter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forSetter() {}
	
	//create point-cut : Include all methods but exclude both getter & setter method
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	private void forCombined() {}

	
	@Before("forCombined()") //Implementing point-cut on advice 
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>> Executing @Before advice on method");		
	}
	
	@Before("forCombined()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");		
	}

}










