package com.et.model;

import java.util.List;
import java.util.Map;

/**
 * javabean是mvc设计模型的模型层（Model），操作数据
 * @author THINK
 *
 */

public class MyDept {

	/**
	 * 封装get方法
	 * @return
	 * @throws Exception
	 */
	
	public String getTable() throws Exception{
		StringBuffer sb=new StringBuffer();
		List<Map> result=DBUtils.query("select * from dept");
		sb.append("<table>");
		sb.append("<tr><th>deptno</th><th>dname</th></tr>");
		for(Map map:result){
			sb.append("<tr><th>"+map.get("deptno")+"</th><th>"+map.get("dname")+"</th></tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}
	
	/**
	 * 封装get方法
	 * @return
	 * @throws Exception
	 */
	public List<Map> getTable1(String name) throws Exception{
		if(name==null){
			name="";
		}
		StringBuffer sb=new StringBuffer();
		List<Map> result=DBUtils.query("select * from dept where deptno like '%"+name+"%'");
		return result;
	}
	
	public Integer getTable1Count(String name) throws Exception{
		if(name==null){
			name="";
		}
		String sql="select count(rowid) as cr from emp where ename like '%"+name+"%'";
		List<Map> result=DBUtils.query(sql);
		return Integer.parseInt(result.get(0).get("CR").toString());
	}
	
	/**
	 * 封装get方法
	 * @return
	 * @throws Exception
	 */
	public PageTools getTable1Pager(String name,Integer curPage) throws Exception{
		if(name==null){
			name="";
		}
		
		Integer totalCount=getTable1Count(name);
		PageTools pt=new PageTools(curPage, totalCount, null);

		
		StringBuffer sb=new StringBuffer();
		
		String sql="select * from (select t.*,rownum rn from emp t where t.ename like '%"+name+"%') where rn>="+pt.getStartIndex()+" and rn<="+pt.getEndIndex();
		
		List<Map> result=DBUtils.query(sql);

		pt.setData(result);
		return pt;
	}
	
}
