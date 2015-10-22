package aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("目标方法的返回值:" + returnValue);
		System.out.println("目标方法的名称:" + method);
		System.out.println("目标对象:" + target);
		logger.info("目标方法执行后的时间:" + new Date());
	}
}
