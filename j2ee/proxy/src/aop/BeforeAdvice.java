package aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void before(Method method, Object[] args, Object target)	throws Throwable {
		System.out.println("����:" + method);
		System.out.println("Ŀ�����:" + target);
		logger.info("��Ŀ�귽����ʼִ��֮ǰ��ʱ��:" + new Date());	
	}
}
