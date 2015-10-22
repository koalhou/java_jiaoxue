package records;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class Recorder {

	private String recordTimes;

	public String getRecordTimes() {
		return recordTimes;
	}

	public void setRecordTimes(String recordTimes) {
		this.recordTimes = recordTimes;
	}
	
	public String recording(){
		ActionContext ac = ActionContext.getContext();
		List<Date> records = (List<Date>)ac.getSession().get("records");
		recordTimes = "";
		if(records == null){
			records = new ArrayList<Date>();
		}
		records.add(new Date());
		ac.getSession().put("records", records);
		for(Date s : records){
			recordTimes = recordTimes + s + "<br/>";
		}
		return "success";
	}
	
}
