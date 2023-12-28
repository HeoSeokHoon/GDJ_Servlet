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
	<h1>Department Detail</h1>
	<h3><%= cD.getCountry_name() %></h3>
	<input id="hdn" type="hidden" value="<%= cD.getCountry_id()%>">
	<button id="btn">수정</button><button id="list">리스트</button>
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let hdn = document.getElementById("hdn");
		let list = document.getElementById("list");
		btn.addEventListener("click", function(){
			window.location.href="./Update.jsp?country_id="+hdn.value;
		});
		list.addEventListener("click", function(){
			window.location.href="./List.jsp"
		});
	</script>
</body>
</html>