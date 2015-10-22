package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextProxy.xml");
		Singer singer = (Singer) ctx.getBean("singer");
		try {
			singer.sing("´óº£");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
