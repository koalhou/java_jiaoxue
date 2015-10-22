package dynaProxy;

import proxy.IPerson;
import proxy.Person;

public class Test {
	public static void main(String[] args) {
		IPerson person = (IPerson) DynaProxyFactory.getProxy(new Person());
	    //返回代理类,代理类是JVM在内存中动态创建的,该类实现传入的接口数组     
	    //的全部接口(的全部方法).
//		System.out.println(person.getClass().getInterfaces());
		person.eating();
		person.sleep();
	}
}
