package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Pure Java Configuration
@EnableAspectJAutoProxy // Spring 
@ComponentScan("com.luv2code.aopdemo") // the places to scan for AOP components and packages
public class DemoConfig {

}
