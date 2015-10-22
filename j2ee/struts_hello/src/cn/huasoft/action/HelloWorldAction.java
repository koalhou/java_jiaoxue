package cn.huasoft.action;

public class HelloWorldAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception {
		this.message = "我的第一个struts2应用,要好好学习";
		System.out.println(message);
		return "success";
	}
	public String other() throws Exception {
		this.message = "我的第二个struts2方法";
		System.out.println(message);
		return "success";
	}

}
