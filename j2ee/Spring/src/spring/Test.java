package spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);
	  public static void main(String args[]) {
	   FileSystemResource rs = new FileSystemResource("bin//applicationContext.xml");
	   BeanFactory factory = new XmlBeanFactory(rs);
	   HelloWorld hello = (HelloWorld)factory.getBean("hellobean");
	   System.out.println(hello.getHello());
	   
	   logger.debug("----------------------------Debug level Info was logged out...");
	   logger.info("----------------------------Info level Info was logged out...");
	   logger.warn("----------------------------Warn level Info was logged out...");
	   logger.error("----------------------------Error level Info was logged out...");
	  }
	}
