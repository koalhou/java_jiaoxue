/**
 * @(#)SystemBootServlet.java 2013-03-16
 *
 * Copyright 2011 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.huasoft.boot;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huasoft.common.HttpConstant;
import com.huasoft.common.ModCommonConstant;
import com.huasoft.memcached.MemcacheCacheManager;
import com.huasoft.tools.PropertiesTools;

/**

 */
public class SystemBootServlet extends HttpServlet {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志记录器.
	 */
	private static Logger logger = LoggerFactory.getLogger(ModCommonConstant.LOGGER_NAME);

	/**
	 * XCPAPI初始化.
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		// 添加处理类型信息至日志
		MDC.put("module", "[MAIN]");
		MDC.put("processType", "[SYSTEM-INIT]");

		// 加载系统中所需要的相关资源
		try {
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
			initConfigParam(webApplicationContext);
			logger.info(""+webApplicationContext.getBean("memcachedClient"));
			loadPropertie(config.getServletContext().getRealPath("/")+File.separator+"WEB-INF"+File.separator+"classes"+File.separator);
			logger.info("-------------------------------");
			logger.info("---安芯移动服务API模块启动成功---");
			logger.info("-------------------------------");
		} catch (final Exception e) {
			logger.error("加载资源信息时出错" + e, e);
			logger.error("-------------------------------");
			logger.error("---安芯移动服务API模块启动失败---");
			logger.error("-------------------------------");

		}

		// 从日志中移除处理类型信息
		MDC.remove("processType");
		MDC.remove("module");
	}

	/**
	 * 加载业务配置信息
	 * @param webApplicationContext
	 */
	private void initConfigParam(WebApplicationContext webApplicationContext) {
//		BaseService bs = (BaseService)webApplicationContext.getBean(BaseService.class);
//		MemcacheCacheManager es = (MemcacheCacheManager)webApplicationContext.getBean(MemcacheCacheManager.class);
//		EtagService es = (EtagService)webApplicationContext.getBean(EtagService.class);
//		List<Map<String, String>> configData = bs.getList("Station.getSystemConfig",null);
//		for(Map<String, String> map : configData){
//			es.put(map.get("PARAM_NAME"), 0, map.get("PARAM_VALUE"));
//		}
//		es.put("test", 1000, "123456");
//		System.out.println(es);
	}

	/**
	 * 获取配置信息
	 * 
	 * @throws IOException
	 * 
	 */
	private void loadPropertie(String path) throws IOException {
		HttpConstant.WEATHER_IMG_PATH = PropertiesTools.readValue(ModCommonConstant.SYS_CONF_FILE, "weather.web.path");
	}

	/**
	 * CLWAPI系统销毁.
	 */
	@Override
	public void destroy() {

		// 添加处理类型信息至日志
		MDC.put("module", "[MAIN]");
		MDC.put("processType", "[SYSTEM-DESTROY]");

		logger.info("-------------------------------");
		logger.info("-----安芯移动服务API模块退出-----");
		logger.info("-------------------------------");

		// 从日志中移除处理类型信息
		MDC.remove("processType");
		MDC.remove("module");
	}

}
