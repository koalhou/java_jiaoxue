package dynaProxy;

import java.lang.reflect.Proxy;

public class DynaProxyFactory {
	//objΪ���������
	public static Object getProxy(Object obj){
		DynaProxyHandler handler = new DynaProxyHandler();
		handler.setTarget(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}
}
