package com.huasoft.tools;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Memcached客服端操作
 * 
 * @author WYL on 2011-12-01
 *
 */
public class TestMemcached {
	private static final Logger logger = LoggerFactory.getLogger(TestMemcached.class);
	private static MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
	private static MemcachedClient client = null;

	static {
		builder.setConnectionPoolSize(30);// 设置连接数
		try {
			client = builder.build();
		} catch (IOException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}
		client.setOpTimeout(20000);// 设置缓存服务器连接时间
	}

	/**
	 * 根据指定的关键字获取对象.
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		Object ob = null;
		try {
			ob = client.get(key);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}/*
		 * finally { if(null != client){ try { client.shutdown(); } catch
		 * (IOException e) { logger.error("error ========== \r\n{}",
		 * e.getMessage()); } } }
		 */
		return ob;
	}

	/**
	 * 删除指定关键字的缓存.
	 * 
	 * @param key
	 * @return
	 */
	public boolean del(String key) {
		boolean flag = false;
		try {
			flag = client.delete(key);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}/*
		 * finally { if(null != client){ try { client.shutdown(); } catch
		 * (IOException e) { logger.error("error ========== \r\n{}",
		 * e.getMessage()); } } }
		 */
		return flag;
	}

	/**
	 * 添加一个指定的值到缓存中
	 * 
	 * @param key
	 * @param expiry
	 *            (单位秒)，超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月）
	 * @param value
	 * @return
	 */
	public boolean add(String key, int expiry, Object value) {
		boolean flag = false;
		try {
			flag = client.add(key, expiry, value);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} /*
		 * finally { if(null != client){ try { client.shutdown(); } catch
		 * (IOException e) { logger.error("error ========== \r\n{}",
		 * e.getMessage()); } } }
		 */
		return flag;
	}

	/**
	 * 添加一个指定的值到缓存中
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean add(String key, Object value) {
		return add(key, 0, value);
	}

	/**
	 * 添加并设置到期时间
	 * 
	 * @param key
	 * @param expiry(单位秒)，超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月）
	 * @param value
	 * @param timeout  (单位毫秒),设置过期时间，如果expiry还未到期，timeout到期，则该memcached过期
	 * @return
	 */
	public boolean add(String key, int expiry, Object value, long timeout) {
		boolean flag = false;
		try {
			flag = client.add(key, expiry, value, timeout);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}/*
		 * finally { if(null != client){ try { client.shutdown(); } catch
		 * (IOException e) { logger.error("error ========== \r\n{}",
		 * e.getMessage()); } } }
		 */
		return flag;
	}

	/**
	 * 添加并设置到期时间
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 *            (单位毫秒),设置过期时间，如果expiry还未到期，timeout到期，则该memcached过期
	 * @return
	 */
	public boolean add(String key, Object value, long timeout) {
		return add(key, 0, value, timeout);
	}

	/**
	 * 替换已存在的key的value，注意类型是Object(统计切勿使用replace)
	 * 
	 * @param key
	 * @param expiry
	 *            (单位秒)，超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月）
	 * @param value
	 * @return
	 */
	public boolean replace(String key, int expiry, Object value) {
		boolean flag = false;
		try {
			flag = client.replace(key, expiry, value);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} /*
		 * finally { if(null != client){ try { client.shutdown(); } catch
		 * (IOException e) { logger.error("error ========== \r\n{}",
		 * e.getMessage()); } } }
		 */
		return flag;
	}

	/**
	 * 替换已存在的key的value，注意类型是Object(统计切勿使用replace)
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean replace(String key, Object value) {
		return replace(key, 0, value);
	}

	/**
	 * 替换已存在的key的value，注意类型是Object(统计切勿使用replace)
	 * 
	 * @param key
	 * @param expiry
	 *            (单位秒)，超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月）
	 * @param value
	 * @param timeout
	 *            (单位毫秒),设置过期时间，如果expiry还未到期，timeout到期，则该memcached过期
	 * @return
	 */
	public boolean replace(String key, int expiry, Object value, long timeout) {
		boolean flag = false;
		try {
			flag = client.replace(key, expiry, value, timeout);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}/*
		 * finally { if(null != client){ try { client.shutdown(); } catch
		 * (IOException e) { logger.error("error ========== \r\n{}",
		 * e.getMessage()); } } }
		 */
		return flag;
	}

	/**
	 * 替换已存在的key的value，注意类型是Object(统计切勿使用replace)
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 *            (单位毫秒),设置过期时间，如果expiry还未到期，timeout到期，则该memcached过期
	 * @return
	 */
	public boolean replace(String key, Object value, long timeout) {
		return replace(key, 0, value);
	}

	/**
	 * 计数器累加inc
	 * 
	 * @param key
	 * @param inc
	 *            递增的幅度大小
	 * @return
	 */
	public long addStats(String key, long inc) {
		long rec = -1;
		Counter counter = client.getCounter(key);
		try {
			rec = counter.incrementAndGet();
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}
		return rec;
	}

	/**
	 * 计数器累加inc
	 * 
	 * @param key
	 * @param inc
	 *            递增的幅度大小
	 * @param original
	 *            key不存在的情况下的初始值
	 * @return
	 */
	public long addStats(String key, long inc, long original) {
		long rec = -1;
		Counter counter = client.getCounter(key, original);
		try {
			rec = counter.incrementAndGet();
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}
		return rec;
	}

	/**
	 * 获取计数器，key不存在则返回-1
	 * 
	 * @param key
	 */
	public long getStats(String key) {
		long rec = -1;
		Counter counter = client.getCounter(key, -1);// 第二个参数是计数器的初始值
		try {
			rec = counter.get();
			// 使用count时实质是在创建一个key，因此需要将这个key清除掉
			if (rec == -1)
				del(key);
		} catch (TimeoutException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (InterruptedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		} catch (MemcachedException e) {
			logger.error("error ========== \r\n{}", e.getMessage());
		}
		return rec;
	}
	public static void main(String[] args) {
		try {
			client.add("abc", 120, "aaaaa");
			System.out.println(client.get("abc"));
			client.shutdown();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("------------");
		
	}
}
