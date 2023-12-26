<%@page import="com.forest.app.Regions.RegionDTO"%>
<%@page import="com.forest.app.Regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RegionDAO regionDAO = new RegionDAO();
	RegionDTO rD = new RegionDTO();
	
	String id = request.getParameter("region_id");
	rD.setRegion_id(Integer.parseInt(id));
	
	rD = regionDAO.getDetail(rD);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Update Page</h1>
	<form action="./UpdateProcess.jsp">
		<div>
			대륙ID <input type="text" readonly="readonly" name="region_id" value="<%= rD.getRegion_id()%>">
		</div>
		<div>
			대륙명 <input type="text" name="region_name" value="<%= rD.getRegion_name()%>">
		</div>
		<button>수정</button>
	</form>
</body>
</html>