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
		System.out.println("����������");
		if(ActionContext.getContext().getSession().get("username") != null){
			String result = invocation.invoke();
			System.out.println("����ֵ�ǣ�" + result);
		}else{
			return "logon";
		}
		return null;
	}

}
