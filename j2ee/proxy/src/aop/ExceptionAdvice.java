package aop;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {

	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("�����ˣ��ػ񵽴���������������ͳһ����");
	}

}
