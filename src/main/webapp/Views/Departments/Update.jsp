<%@page import="com.forest.app.departments.DepartmentDTO"%>
<%@page import="com.forest.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO dD = new DepartmentDTO();
	
	String id = request.getParameter("department_id");
	dD.setDepartment_id(Integer.parseInt(id));
	dD = departmentDAO.getDetail(dD);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Update Page</h1>
	<form action="./UpdateProcess.jsp">
		<div>
			부서ID <input type="text" readonly="readonly" name="department_id" value="<%= dD.getDepartment_id()%>">
		</div>
		<div>
			부서명 <input type="text" name="department_name" value="<%= dD.getDepartment_name()%>">
		</div>
		<div>
			부사장ID <input type="text" name="manager_id" value="<%= dD.getManager_id()%>">
		</div>
		<div>
			주소ID <input type="text" name="location_id" value="<%= dD.getLocation_id()%>">
		</div>
		<button>수정</button>
	</form>
</body>
</html>