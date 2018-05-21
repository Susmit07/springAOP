package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3) // @Order - Guarantees order of execution of aspects by Spring.
public class MyDemoLoggingAspect {

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")	
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @Around on method: " + method);
		// get begin time-stamp
		long begin = System.currentTimeMillis();
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		// get end time-stamp
		long end = System.currentTimeMillis();
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {

		String calledMethod = theJoinPoint.getSignature().toShortString(); // Returns an abbreviated string representation of the join point.
		System.out.println("Executing @AfterFinally on the method: "+calledMethod);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theThrow")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theThrow) {

		String calledMethod = theJoinPoint.getSignature().toShortString(); // Returns an abbreviated string representation of the join point.
		System.out.println("Executing @AfterThrowing on the method: "+calledMethod);

		// Log the exception.
		System.out.println("MyDemoLoggingAspect:The exception is: "+theThrow);
	}

	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result") // Implementing after returning advice.
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String calledMethod = theJoinPoint.getSignature().toShortString(); // Returns an abbreviated string representation of the join point.
		System.out.println("Executing @AfterReturning on the method: "+calledMethod);
		System.out.println("MyDemoLoggingAspect:The result is :"+result);

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










