package com.huasoft.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//��ȡ�����ļ�
			Configuration cfg=new Configuration().configure();
			//���幤���� 
			SchemaExport export=new SchemaExport(cfg);
			
			//ִ�е���
			export.create(true,true);
			
		} catch (Exception e) {
           e.printStackTrace();
		}
	}

}
