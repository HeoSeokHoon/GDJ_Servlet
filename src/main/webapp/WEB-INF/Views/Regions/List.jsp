<%@page import="com.forest.app.Regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.forest.app.Regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//java 구역: 스크립틀릿
	//request 변수명
	List<RegionDTO> ar = (List<RegionDTO>)request.getAttribute("list");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regions List</h1>
	<table>
		<thead>
			<tr>
				<th>REGION_ID</th>
				<th>REGION_NAME</th>
			</tr>
		</thead>
		
		<tbody>
			<%for(RegionDTO rD : ar){ //표현식 %> 
				<tr>
					<td><%= rD.getRegion_id() %></td>
					<td><a href="./detail?region_id=<%= rD.getRegion_id()%>"><%= rD.getRegion_name() %></a></td>
				</tr>
			<%} %>
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