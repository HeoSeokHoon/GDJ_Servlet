<%@page import="com.forest.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.forest.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	List<DepartmentDTO> ar = departmentDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Departments List</h1>
	<table>
		<thead>
			<tr>
				<th>DEPARTMENT_ID</th>
				<th>DEPARTMENT_NAME</th>
				<th>MANAGER_ID</th>
				<th>LOCATION_ID</th>
			</tr>
		</thead>
		<tbody>
			<%for(DepartmentDTO departmentDTO : ar){%>
				<tr>
					<td><%=departmentDTO.getDepartment_id() %></td>
					<td><a href="./Detail.jsp?department_id=<%= departmentDTO.getDepartment_id()%>"><%=departmentDTO.getDepartment_name() %></a></td>
					<td><%=departmentDTO.getManager_id() %></td>
					<td><%=departmentDTO.getLocation_id() %></td>
				</tr>
			<%}%>
			<tr>
			</tr>
		</tbody>
	</table>
	
	<button id="btn">부서추가</button>
	<button id="home">홈페이지로 이동</button>
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let hdn = document.getElementById("home");
		btn.addEventListener("click", function(){
			window.location.href="./Add.jsp";
		});
		home.addEventListener("click", function(){
			window.location.href="../Home.jsp"
		});
	</script>
</body>
</html>