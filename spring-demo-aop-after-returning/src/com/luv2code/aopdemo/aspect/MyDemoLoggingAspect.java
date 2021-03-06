package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3) // @Order - Guarantees order of execution of aspects by Spring.
public class MyDemoLoggingAspect {

	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result") // Implementing after returning advice.
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String calledMethod = theJoinPoint.getSignature().toShortString(); // Returns an abbreviated string representation of the join point.
		System.out.println("Executing @AfterReturning on the method: "+calledMethod);
		System.out.println("The result is :"+result);
		
		//Let's post process the data
		convertAccountNamestoUpperCase(result);
	}
	
	private void convertAccountNamestoUpperCase(List<Account> result) {
		for(Account tempAccount : result) {
			String uppercase = tempAccount.getAccName().toUpperCase();
			tempAccount.setAccName(uppercase);
		}
	}

	@Before("com.luv2code.aopdemo.aspect.AOPPointCutexpressions.forCombined()") //Implementing point-cut on advice 
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>> Executing @Before advice on method");		
	}
}










