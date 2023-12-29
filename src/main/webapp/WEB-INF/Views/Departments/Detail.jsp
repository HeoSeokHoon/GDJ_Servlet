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
	<input id="hdn" type="hidden" value="<%= departmentDTO.getDepartment_id()%>">
	<button id="btn">수정</button><button id="list">리스트</button>
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let hdn = document.getElementById("hdn");
		let list = document.getElementById("list");
		btn.addEventListener("click", function(){
			window.location.href="./Update.jsp?department_id="+hdn.value;
		});
		list.addEventListener("click", function(){
			window.location.href="./List.jsp"
		});
	</script>
</body>
</html>