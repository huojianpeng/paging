package com.et.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.generic.Select;

public class DBUtils {
	
	//newproperties��̬����
	static Properties p=new Properties();
	static{
		//��ȡjdbc.properties�ļ�
		InputStream is=DBUtils.class.getResourceAsStream("jdbc.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ����
	 */
	public static Connection getConnection() throws Exception{
		//��ȡurl
		String url=p.getProperty("url");
		//��ȡ����
		String driverClass=p.getProperty("driverClass");
		//��ȡ�û���
		String uname=p.getProperty("username");
		//��ȡ����
		String password=p.getProperty("password");
		Class.forName(driverClass);
		//��¼�ɹ�
		Connection conn=DriverManager.getConnection(url,uname,password);
		return conn;
	}
	
	
	public static List<Map>query(String sql) throws Exception{
		
		Connection conn= getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		List list=new ArrayList<Object>();
		//��ȡ�еĸ���
		int columnCount=rsmd.getColumnCount();
		while(rs.next()){
			Map map=new HashMap<Object, Object>();
			for(int i=1; i<=columnCount; i++){
				String colName=rsmd.getColumnName(i);
				String colValue=rs.getString(i);
				map.put(colName, colValue);
			}
			list.add(map);
		}
		return list;
	}
	
	public static void main(String[] args) throws Exception{
		
		List<Map> result=query("select * from dept");
		System.out.println(result);
	}
	
	
}
