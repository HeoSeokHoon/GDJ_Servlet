<%@page import="com.forest.app.Regions.RegionDTO"%>
<%@page import="com.forest.app.Regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RegionDAO regionDAO = new RegionDAO();
	RegionDTO regionDTO = new RegionDTO();
	String  n = request.getParameter("region_id");
	int num = Integer.parseInt(n);
	regionDTO.setRegion_id(num);
	regionDTO = regionDAO.getDetail(regionDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3><%= regionDTO.getRegion_name()%></h3>
</body>
</html>