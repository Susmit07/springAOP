package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // @Order - Guarantees order of execution of aspects by Spring.
public class ApiAnalyticsAspect {

	@Before("com.luv2code.aopdemo.aspect.AOPPointCutexpressions.forCombined()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");		
	}
}
