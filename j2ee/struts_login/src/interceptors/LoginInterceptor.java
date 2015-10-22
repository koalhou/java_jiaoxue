package interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1231961563706512817L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入拦截器");
		if(ActionContext.getContext().getSession().get("username") != null){
			String result = invocation.invoke();
			System.out.println("返回值是：" + result);
		}else{
			return "logon";
		}
		return null;
	}

}
