
package com.huasoft.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huasoft.common.ErrorConstant;
import com.huasoft.common.HttpConstant;
import com.huasoft.common.ModCommonConstant;
import com.huasoft.exceptions.JacksonDeserializeException;

/**
 
 */
@Provider
@Produces({ HttpConstant.MEDIATYPE_JSON_UTF_8 })
public class JacksonDeserializeExceptionMapper implements ExceptionMapper<JacksonDeserializeException> {

	/**
	 * 日志记录器.
	 */
	private static Logger logger = LoggerFactory.getLogger(ModCommonConstant.LOGGER_NAME);

	@Override
	public Response toResponse(JacksonDeserializeException e) {
		logger.error("将JSON字符串转换成指定的类型对象出错", e);
		return Response.status(Response.Status.BAD_REQUEST).entity(ErrorConstant.ERROR10002.toJson()).build();
	}

}
