package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AroundAdvice implements MethodInterceptor{

	private static Logger logger = LoggerFactory.getLogger(AroundAdvice.class);
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		logger.info("��仰��Ŀ�귽��֮ǰִ�С���");
		Object result = mi.proceed();
		logger.info("��仰��Ŀ�귽��֮��ִ�С���");
		return result;
	}

}
