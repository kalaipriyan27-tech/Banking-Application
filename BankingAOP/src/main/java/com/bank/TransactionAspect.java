
package com.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Before("execution(* com.bank.BankingService.deposit(..))")
    public void beforeDeposit(JoinPoint joinPoint) {
        System.out.println("[AOP] Starting deposit transaction...");
    }

    @Before("execution(* com.bank.BankingService.withdraw(..))")
    public void beforeWithdraw(JoinPoint joinPoint) {
        System.out.println("[AOP] Starting withdrawal transaction...");
    }

    @AfterReturning("execution(* com.bank.BankingService.deposit(..))")
    public void afterDeposit() {
        System.out.println("[AOP] Deposit transaction completed successfully.");
    }

    @AfterReturning("execution(* com.bank.BankingService.withdraw(..))")
    public void afterWithdraw() {
        System.out.println("[AOP] Withdrawal transaction completed successfully.");
    }

    @AfterThrowing(
        pointcut = "execution(* com.bank.BankingService.*(..))",
        throwing = "exception"
    )
    public void afterThrowing(Exception exception) {
        System.out.println("[AOP] Transaction failed: " + exception.getMessage());
    }
}


