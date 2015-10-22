package dynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynaProxyHandler implements InvocationHandler {

	private Logger logger = LoggerFactory.getLogger(DynaProxyHandler.class);	
	private Object target;//���������
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.info("ִ�п�ʼʱ��:" + new Date());
		Object result = method.invoke(target, args);
		logger.info("ִ�н���ʱ��:" + new Date());
		return result;//����methodִ�н��
	}

}
