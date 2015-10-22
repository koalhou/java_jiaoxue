package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class Test {
	public static void main(String[] args) {
//		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{"src/applicationContextProxy.xml"});
//		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{"src/applicationContextProxyName.xml"});
//		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{"src/applicationContextProxyPatten.xml"});
//		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{"src/applicationContextProxyAuto.xml"});
		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{"src/applicationContextThrows.xml"});
		IBank bank = (IBank) ac.getBean("proxy");//这里的参数是代理工厂的ID
		bank.setMoney(1000);
		bank.getMoney(1000);
	}
}
