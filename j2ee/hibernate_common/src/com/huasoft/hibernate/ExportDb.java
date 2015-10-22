package com.huasoft.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//读取配置文件
			Configuration cfg=new Configuration().configure();
			//定义工具类 
			SchemaExport export=new SchemaExport(cfg);
			
			//执行导出
			export.create(true,true);
			
		} catch (Exception e) {
           e.printStackTrace();
		}
	}

}
