package count;

import com.opensymphony.xwork2.ActionContext;

public class Counter {

	private String app_val;
	
	private String session_val;
	
	private String req_val;

	public String getApp_val() {
		return app_val;
	}

	public void setApp_val(String app_val) {
		this.app_val = app_val;
	}

	public String getSession_val() {
		return session_val;
	}

	public void setSession_val(String session_val) {
		this.session_val = session_val;
	}

	public String getReq_val() {
		return req_val;
	}

	public void setReq_val(String req_val) {
		this.req_val = req_val;
	}
	
	public String app_count(){
		ActionContext ac = ActionContext.getContext();
		Integer index = (Integer)ac.getApplication().get("app_val");
		if(index == null){
			ac.getApplication().put("app_val", 1);
			app_val = String.valueOf(1);
		}else{
			ac.getApplication().put("app_val", index+1);
			app_val = String.valueOf(index + 1);
		}
		return "success";
	}
	
	public String session_count(){
		ActionContext ac = ActionContext.getContext();
		Integer index = (Integer)ac.getSession().get("session_val");
		if(index == null){
			ac.getSession().put("session_val", 1);
			session_val = String.valueOf(1);
		}else{
			ac.getSession().put("session_val", index+1);
			session_val = String.valueOf(index + 1);
		}
		return "success";
	}
	
	public String req_count(){
		ActionContext ac = ActionContext.getContext();
		Integer index = (Integer)ac.get("req_val");
		if(index == null){
			ac.put("req_val", 1);
			req_val = String.valueOf(1);
		}else{
			ac.put("req_val", index+1);
			req_val = String.valueOf(index + 1);
		}
		return "success";
	}
}
