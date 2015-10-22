package account;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import common.Constant;

public class Account extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1088347266061171660L;

	private String url;

	private String message;

	private String username;

	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void validate() {
		if (username == null || "".equals(username.trim())){
			this.addFieldError("username", "Action��У�鱨���û�������Ϊ��");
			message = "Action��У�飺�����û�������";
		}
	}

	public void validateLogin() {
		if (username == null || "".equals(username.trim())) {
			this.addFieldError("username", "ActionУ�鷽�������û�������Ϊ��");
			message = "Action����У�������û�������";
		}
	}

	public String login() {
		if (null == username || null == password) {
			message = "���������ȫ������";
			return "faild";
		}
		if (Constant.users.get(username) == null) {
			message = "�û���������";
			return "faild";
		}
		if (!password.equals(Constant.users.get(username))) {
			message = "��¼�����";
		}
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("username", username);
		return "success";
	}

}
