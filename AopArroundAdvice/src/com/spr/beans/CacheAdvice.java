package com.spr.beans;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.support.MethodReplacer;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class CacheAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInterceptor) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = null;
		methodName = methodInterceptor.getMethod().getName();
		Object[] args = null;
		args = methodInterceptor.getArguments();
		String key = null;
		Cache ch = Cache.getInstance();
		
		key = methodName + "(" + args[0] + "," + args[1] + ")";
		
		if(ch.containsKey(key))
		{
			return ch.get(key);
		}
		Monitor monitor = MonitorFactory.start(methodName);
		Object ret = methodInterceptor.proceed();
		monitor.stop();
		System.out.println(monitor);
		System.out.println(MonitorFactory.getReport());
		ch.put(key, ret);
		return ret;
		
	}

	
	

	
}
