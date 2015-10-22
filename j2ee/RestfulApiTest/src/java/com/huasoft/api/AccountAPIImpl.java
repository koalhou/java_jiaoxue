package com.huasoft.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huasoft.common.ErrorConstant;
import com.huasoft.entity.UserInfo;
import com.huasoft.entity.Verify;
import com.huasoft.exceptions.ApplicationException;
import com.huasoft.tools.JacksonUtils;
import com.huasoft.tools.ValidateUtil;

public class AccountAPIImpl implements AccountAPI {
	private static Logger logger = LoggerFactory.getLogger(AccountAPIImpl.class);
	// access_token超时时间设置,单位:分钟.
	public static int ACCESS_TOKEN_EXPIRE_TIME = 10080;
	// 配置文件中存放access_token超时时间配置的key�?.
	public static String ACCESS_TOKEN_EXPIRE_TIME_KEY = "token.expire.interval";
	@Context
	private MessageContext context;

	@Override
	public Response verifyPhone(String phone) {
		if(!ValidateUtil.isPhone(phone)){
			logger.error("手机号{}错误",phone);
			throw new ApplicationException(ErrorConstant.ERROR10002, Response.Status.BAD_REQUEST);
		}
		logger.info("GET METHOD IS CALLED");
//		Integer i = baseService.get("Account.verifyPhone", phone);

		Verify ver = new Verify();
		ver.setVerify_result(1);
		return Response.ok().entity(JacksonUtils.toJsonRuntimeException(ver)).build();
	}
	
	@Override
	public Response verifyAccount(String req) {
		Map<?, ?> map = JacksonUtils.jsonToMapRuntimeException(req);
		Object account = map.get("account");
//		Object type = map.get("type");
		if(null == account || "".equals(String.valueOf(account))){
			logger.info("AccountAPI �? accountcheck，关键参数不足！");
			throw new ApplicationException(ErrorConstant.ERROR10001,Response.Status.BAD_REQUEST);
		}
		Map<String, String> check_conditions = new HashMap<String, String>();
		check_conditions.put("account", String.valueOf(account));
//		if("0".equals(type)){
//		}else if("1".equals(type)){
//			checkUser.setEmp_code(usr_account);
//		}else if("2".equals(type)){
//			checkUser.setYgb_tel(usr_account);
//		}
		List<UserInfo>  usrInfoList= new ArrayList<UserInfo>(); //accountService.getUserByAccount(check_conditions);
		
		if(usrInfoList.size() < 1){
			logger.error("AccountAPI �? accountcheck ：账号{}错误" , account);
			throw new ApplicationException(ErrorConstant.ERROR10012, Response.Status.BAD_REQUEST);
		}
		
		UserInfo rst = usrInfoList.get(0);
		return Response.ok().entity(JacksonUtils.toJsonRuntimeException(rst)).build();
	}

}
