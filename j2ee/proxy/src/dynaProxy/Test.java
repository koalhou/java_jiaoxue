package dynaProxy;

import proxy.IPerson;
import proxy.Person;

public class Test {
	public static void main(String[] args) {
		IPerson person = (IPerson) DynaProxyFactory.getProxy(new Person());
	    //���ش�����,��������JVM���ڴ��ж�̬������,����ʵ�ִ���Ľӿ�����     
	    //��ȫ���ӿ�(��ȫ������).
//		System.out.println(person.getClass().getInterfaces());
		person.eating();
		person.sleep();
	}
}
