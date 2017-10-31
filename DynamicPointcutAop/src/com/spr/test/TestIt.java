package com.spr.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.spr.beans.Calculator;
import com.spr.beans.LoggingAdvise;
import com.spr.beans.LoggingDynamicPointcut;

public class TestIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 ProxyFactory pf=new ProxyFactory();
 pf.setTarget(new Calculator());
 pf.addAdvisor(new DefaultPointcutAdvisor(new LoggingDynamicPointcut(),new LoggingAdvise()));
 
 Calculator proxy =(Calculator)pf.getProxy();
int sum = proxy.add(800,900);
System.out.println(sum);
int mul = proxy.mul(100,200);
System.out.println(mul);
 
	}

}
