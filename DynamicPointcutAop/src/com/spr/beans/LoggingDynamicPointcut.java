package com.spr.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class LoggingDynamicPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> classtype, Object... args) {
		
		if(classtype.isAssignableFrom(Calculator.class) && method.getName().equals("add") && (Integer)args[0] > 700 && (Integer)args[1] > 700)
{
			System.out.println("inside add pointcut ");
	return true;
}

		return false;
	}

}
