
<%@page import="com.forest.app.countries.CountriesDTO"%>
<%@page import="com.forest.app.countries.CountriesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CountriesDAO cDao = new CountriesDAO();
	CountriesDTO cD = new CountriesDTO();
	
	cD.setCountry_id(request.getParameter("country_id"));
	cD = cDao.getDetail(cD);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Countries Update Page</h1>
	<form action="./AddProcess.jsp">
		<div>
			나라ID <input type="text" readonly="readonly" name="country_id" value="<%= cD.getCountry_id()%>">
		</div>
		<div>
			나라명 <input type="text" name="country_name" value="<%= cD.getCountry_name()%>">
		</div>
		<div>
			대륙ID <input type="text" name="region_id" value="<%= cD.getRegion_id()%>">
		</div>
		<button>수정</button>
	</form>
</body>
</html>