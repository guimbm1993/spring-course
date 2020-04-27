package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	//create pointcut to match getter methods
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//create pointcut to match setter methods
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcut: include package ... exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {}
	
	@Before("forDAOPackageNoGetterSetter()") //aplicando pointcut declaration
	public void beforeAddAccountAdvice() {
		System.out.println("========>>>> Executing @Before advice on addAccount");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=========>>>> Performing API analytics");
	}
}
