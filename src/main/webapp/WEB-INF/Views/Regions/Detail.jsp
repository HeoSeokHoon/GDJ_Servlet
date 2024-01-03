<%@page import="com.forest.app.Regions.RegionDTO"%>
<%@page import="com.forest.app.Regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RegionDTO rD = (RegionDTO)request.getAttribute("detail");
	//String  n = request.getParameter("region_id");
	//int num = Integer.parseInt(n);
	//rD.setRegion_id(num);
	//rD = rDao.getDetail(rD);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3>${requestScope.detail.region_id}</h3>
		<h3>${requestScope.detail.region_name}</h3>
	<input id="hdn" type="hidden" value="${requestScope.detail.region_id}">
	<button id="btn">수정</button><button id="list">리스트</button>
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let hdn = document.getElementById("hdn");
		let list = document.getElementById("list");
		btn.addEventListener("click", function(){
			window.location.href="./Update.jsp?region_id="+hdn.value;
		});
		list.addEventListener("click", function(){
			window.location.href="./List.jsp"
		});
	</script>
</body>
</html>