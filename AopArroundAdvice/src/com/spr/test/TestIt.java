package com.spr.test;

import org.springframework.aop.framework.ProxyFactory;

import com.spr.beans.CacheAdvice;
import com.spr.beans.Calculator;
import com.spr.beans.LoggingAdvice;

public class TestIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ProxyFactory ft = new ProxyFactory();
       ft.setTarget(new Calculator());
       ft.addAdvice(new CacheAdvice());
       ft.addAdvice(new LoggingAdvice());
       
       Calculator proxy = (Calculator)ft.getProxy();
        int result = proxy.add(10,20);
        System.out.println(result);
        int result1 = proxy.add(15,20);
        System.out.println(result1);
       
	}

}
