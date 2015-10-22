package aop;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {

	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("出错了，截获到错误可以在这里进行统一处理");
	}

}
