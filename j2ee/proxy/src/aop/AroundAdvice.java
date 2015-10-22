package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AroundAdvice implements MethodInterceptor{

	private static Logger logger = LoggerFactory.getLogger(AroundAdvice.class);
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		logger.info("这句话在目标方法之前执行。。");
		Object result = mi.proceed();
		logger.info("这句话在目标方法之后执行。。");
		return result;
	}

}
