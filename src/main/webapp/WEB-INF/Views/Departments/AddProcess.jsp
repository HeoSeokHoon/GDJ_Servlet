<%@page import="com.forest.app.Regions.RegionDAO"%>
<%@page import="com.forest.app.departments.DepartmentDTO"%>
<%@page import="com.forest.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	String id = request.getParameter("department_id");
	String name = request.getParameter("department_name");
	String manager = request.getParameter("manager_id");
	String location = request.getParameter("location_id");
	
	departmentDTO.setDepartment_id(Integer.parseInt(id));
	departmentDTO.setDepartment_name(name);
	departmentDTO.setManager_id(Integer.parseInt(manager));
	departmentDTO.setLocation_id(Integer.parseInt(location));
	
	int result = departmentDAO.add(departmentDTO);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add Process</h1>
	
	<script type="text/javascript">
		let result='<%= result%>';
		if(result>0){
			alert("등록 성공");	
		}else{
			alert("등록 실패");
		}
		
		window.location.href="./List.jsp";
	</script>

</body>
</html>