
package com.huasoft.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.huasoft.common.ErrorConstant;
import com.huasoft.common.HttpConstant;
import com.huasoft.common.ModCommonConstant;

/**
 
 * 
 */
@Provider
@Produces({ HttpConstant.MEDIATYPE_JSON_UTF_8 })
public class DataAccessExceptionMapper implements ExceptionMapper<DataAccessException> {

	/**
	 * 日志记录器.
	 */
	private static Logger logger = LoggerFactory.getLogger(ModCommonConstant.LOGGER_NAME);

	@Override
	public Response toResponse(DataAccessException e) {
		logger.error("发生数据异常", e);
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorConstant.ERROR90000.toJson()).build();
	}

}
