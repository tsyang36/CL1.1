package com.tsy.cl.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *  
 * @Title: BasicDao.java
 * @Package com.zrycx.millet.util
 * @Description: TODO
 * @author Tang
 * @date 2017年8月16日 下午3:35:52
 * @version 1.0
 */
public class BasicDao {
	private static final String Driver ="com.mysql.jdbc.Driver";
	
	private static final String Url ="jdbc:mysql://localhost/cl";
	
	private static final String User ="root";
	
	private static final String Pwd ="root";
	
	protected Connection getConnection(boolean tag) throws Exception {
		Class.forName(Driver);
		
		Connection connection = DriverManager.getConnection(Url, User, Pwd);
		
		connection.setAutoCommit(tag);
		
		return connection;
	}

}
