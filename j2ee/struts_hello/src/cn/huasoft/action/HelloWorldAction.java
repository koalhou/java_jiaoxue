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
		this.message = "�ҵĵ�һ��struts2Ӧ��,Ҫ�ú�ѧϰ";
		System.out.println(message);
		return "success";
	}
	public String other() throws Exception {
		this.message = "�ҵĵڶ���struts2����";
		System.out.println(message);
		return "success";
	}

}
