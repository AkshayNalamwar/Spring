package com.spr.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	
	private static Cache instance;
	private Map<String,Object> datamap;
	
	private Cache()
	{
		datamap =new ConcurrentHashMap<String,Object>();
	}

	public synchronized static Cache getInstance()
	{
		if(instance == null)
		{
			instance = new Cache();
		}
		return instance;
	}
	
	public void put(String key,Object value)
	{
		datamap.put(key, value);
	}
	public Object get(String key)
	{
		return datamap.get(key);
	}
	public boolean containsKey(String key)
	{
		return datamap.containsKey(key);
	}
}
