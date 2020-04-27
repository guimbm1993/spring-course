package com.luv2code.aopdemo.aspect;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))" ,
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out wich method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterThrowing on method: " + method);
		
		//log the exception
		System.out.println("\n=======>>>> the exception is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterReturning on method: " + method);
		
		//print out the results of the method call
		System.out.println("\n=======>>> result is: " + result);
		
		//let's post-process the data.... let's modify it
		convertAccountNamesToUpperCase(result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		if(!result.isEmpty()) {
			for(Account temp: result) {
				temp.setName(temp.getName().toUpperCase());
			}
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()") //aplicando pointcut declaration
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("========>>>> Executing @Before advice on addAccount");
		
		//display the method signature
		MethodSignature theSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + theSignature);
		
		//display the methods arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru args
		for(Object aux: args) {
			System.out.println("Arg: " + aux);
			
			if(aux instanceof Account) {
				//downcast and print Account specific stuff
				Account theAccount  = (Account) aux;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}

}
