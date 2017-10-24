package com.spr.beans;

import java.lang.invoke.MethodHandleInfo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// TODO Auto-generated method stub
		String methodName=null;
		Object[] args =null;
		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		System.out.println("entering into method name " + methodName + "(" + args[0] + "," + args[1] + ")" );
		
		Object ret = methodInvocation.proceed();
		
		System.out.println("ending of method name " + methodName + " which is returning " + ret + " value");
		 
		return ret;
	}

}
