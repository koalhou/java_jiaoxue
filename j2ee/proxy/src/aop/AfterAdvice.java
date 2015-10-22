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
		System.out.println("Ŀ�귽���ķ���ֵ:" + returnValue);
		System.out.println("Ŀ�귽��������:" + method);
		System.out.println("Ŀ�����:" + target);
		logger.info("Ŀ�귽��ִ�к��ʱ��:" + new Date());
	}
}
