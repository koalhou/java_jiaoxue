package com.huasoft.quartz;

import org.springframework.beans.factory.annotation.Autowired;

import com.huasoft.memcached.MemcacheCache;

public class Quartz {
	
	@Autowired
	private MemcacheCache cache;

	public void doTask(){
		System.out.println("------------------------");
		cache.put("22", "11");
	}

	public MemcacheCache getCache() {
		return cache;
	}

	public void setCache(MemcacheCache cache) {
		this.cache = cache;
	}
	
}
