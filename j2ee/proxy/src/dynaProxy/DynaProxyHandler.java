package dynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynaProxyHandler implements InvocationHandler {

	private Logger logger = LoggerFactory.getLogger(DynaProxyHandler.class);	
	private Object target;//被代理对象
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.info("执行开始时间:" + new Date());
		Object result = method.invoke(target, args);
		logger.info("执行结束时间:" + new Date());
		return result;//返回method执行结果
	}

}
