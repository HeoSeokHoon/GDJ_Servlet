<%@page import="com.forest.app.departments.DepartmentDTO"%>
<%@page import="com.forest.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO dD = new DepartmentDTO();
	
	dD.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
	dD.setDepartment_name(request.getParameter("department_name"));
	dD.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
	dD.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
	
	int result = departmentDAO.update(dD);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Update Process</h1>
	<script type="text/javascript">
		let result = <%= result%>;
		if(result>0){
			alert("수정 성공");
		}else{
			alert("수정 실패");
		}
		
		location.href="./Detail.jsp?department_id=<%= request.getParameter("department_id")%>";
	</script>
</body>
</html>