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
	
	//this is where  we add all of our related advices for logging
	
	
	//let's start with an @Before advice
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") //apenas o metodo addAccount da classe AccountDAO
//	@Before("execution(public void add*())") //qualquer metodo que comece com add
//	@Before("execution(* add*(com.luv2code.aopdemo.Account))") //qualquer metdod de qualquer tipo de retorno que comece com add e que tenha Account como parametro
//	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") //qualquer metodo com qualquer retorno, que comece com add, que tenha uma parâmetro do tipo Account e qualquer outro parametro 
//	@Before("execution(* add*(..))") //qualquer metodo com qualquer retorno, que comece com add, e que tenha qualquer tipo de parametro
//	@Before("execution( * com.luv2code.aopdemo.dao.*.*(..))") //qualquer metodo com qualquer retorno que tenha qualquer parametro, mas deve estar dentro do pacote
	@Before("forDAOPackage()") //aplicando pointcut declaration
	public void beforeAddAccountAdvice() {
		System.out.println("========>>>> Executing @Before advice on addAccount");
	}
	
	@Before("forDAOPackage()")
	public void performApiAnalytics() {
		System.out.println("=========>>>> Performing API analytics");
	}
}
