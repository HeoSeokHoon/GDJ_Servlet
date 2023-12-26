<%@page import="com.forest.app.departments.DepartmentDTO"%>
<%@page import="com.forest.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	String n = request.getParameter("department_id");
	int num = Integer.parseInt(n);
	departmentDTO.setDepartment_id(num);
	departmentDTO = departmentDAO.getDetail(departmentDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Detail</h1>
	<h3><%= departmentDTO.getDepartment_name() %></h3>
</body>
</html>