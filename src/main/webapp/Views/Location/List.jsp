<%@page import="com.forest.app.countries.CountriesDTO"%>
<%@page import="com.forest.app.countries.CountriesDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CountriesDAO cDao = new CountriesDAO();
	List<CountriesDTO> ar = cDao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Countries List</h1>
	<table>
		<thead>
			<tr>
				<th>COUNTRY_ID</th>
				<th>COUNTRY_NAME</th>
				<th>REGION_ID</th>
			</tr>
		</thead>
		<tbody>
			<%for(CountriesDTO cD : ar){%>
				<tr>
					<td><%=cD.getCountry_id() %></td>
					<td><a href="./Detail.jsp?country_id=<%= cD.getCountry_id()%>"><%=cD.getCountry_name() %></a></td>
					<td><%=cD.getRegion_id() %></td>
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