package com.huasoft.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.huasoft.common.HttpConstant;

public interface AccountAPI {

	/**
	 * 手机号码验证接口
	 * 
	 * @param phone 手机
	 * 
	 * @return 验证结果信息
	 */
	@GET
	@Path(value = "phone/{usr_phone}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ HttpConstant.MEDIATYPE_JSON_UTF_8 })
	Response verifyPhone(@PathParam("usr_phone") String phone);
	
	/**
	 * 账号验证接口
	 * 
	 * @param account 账号
	 * 
	 * @return 验证结果信息
	 */
	@POST
	@Path(value = "accountcheck")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ HttpConstant.MEDIATYPE_JSON_UTF_8 })
	Response verifyAccount(String account);
	
}
