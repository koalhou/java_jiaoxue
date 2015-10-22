package proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonProxy implements IPerson {

	private IPerson person;
	private Logger logger = LoggerFactory.getLogger(PersonProxy.class);

	public PersonProxy(IPerson person) {
		this.person = person;
	}

	public void eating() {
		logger.info("��ʼִ��ʱ��:�� + new Date()");
		person.eating();
		logger.info("��ִ�н���ʱ��:�� + new Date()");
	}

	public void sleep() {
		logger.info("��ʼִ��ʱ��:�� + new Date()");
		person.sleep();
		logger.info("��ִ�н���ʱ��:�� + new Date()");
	}

}