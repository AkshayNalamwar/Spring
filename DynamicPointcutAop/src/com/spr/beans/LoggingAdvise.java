package com.spr.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvise implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// TODO Auto-generated method stub
		String methodName=methodInvocation.getMethod().getName();
		System.out.println("entering to the method " + methodName);
		Object ret =methodInvocation.proceed();
		System.out.println("returning the value " + ret);
		return ret;
	}

}
