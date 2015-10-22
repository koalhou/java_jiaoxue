package aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void before(Method method, Object[] args, Object target)	throws Throwable {
		System.out.println("方法:" + method);
		System.out.println("目标对象:" + target);
		logger.info("在目标方法开始执行之前的时间:" + new Date());	
	}
}
