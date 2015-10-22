package account;

import com.opensymphony.xwork2.ActionContext;

import common.Constant;

public class Account {
	
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
	
	public String login(){
		if(null == username || null==password){
			message="输入参数不全，请检查";
			return "faild";
		}
		if(Constant.users.get(username) == null){
			message = "用户名不存在";
			return "faild";
		}
		if(!password.equals(Constant.users.get(username))){
			message ="登录密码错";
		}
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("username", username);
		return "success";
	}
	
}
