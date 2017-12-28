<!-- jsp是MVC设计模式中的View层 
	主要是和用户进行交互（肉眼看到的界面） 只允许出现html标记el表达式，标签
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/EmpServlet">
		<input type="text" name="deptno"/>
		<input type="submit" value="提交"/>
	</form>
	<table>
		<tr><th>员工编号</th><th>员工姓名</th><th>员工职位</th><th>上级编号</th><th>雇佣日期</th><th>员工薪水</th><th>佣金</th><th>部门编号</th></tr>
		<c:forEach var="tmp" items="${requestScope.table1.data }">
			<tr>
				<td>${pageScope.tmp.EMPNO }</td>
				<td>${pageScope.tmp.ENAME }</td>
				<td>${pageScope.tmp.JOB }</td>
				<td>${pageScope.tmp.MGR }</td>
				<td>${pageScope.tmp.HIREDATE }</td>
				<td>${pageScope.tmp.SAL }</td>
				<td>${pageScope.tmp.COMM }</td>
				<td>${pageScope.tmp.DEPTNO }</td>
			</tr>
		</c:forEach>
		
		<tr><td colspan="3">
			<a href="${pageContext.request.contextPath }/EmpServlet?curPage=1">首页</a>
			<a href="${pageContext.request.contextPath }/EmpServlet?curPage=${requestScope.table1.prePage}">上一页</a>
			
			<c:forEach var="i" begin="1" end="${requestScope.table1.totalPage}" step="1">
				<a href="${pageContext.request.contextPath }/EmpServlett?curPage=${pageScope.i}">${pageScope.i}</a>
				
			</c:forEach>
			
			<a href="${pageContext.request.contextPath }/EmpServlet?curPage=${requestScope.table1.nextPage}">下一页</a>
			<a href="${pageContext.request.contextPath }/EmpServlet?curPage=${requestScope.table1.totalPage}">尾页</a>
		</td></tr>
		
	</table>
</body>
</html>