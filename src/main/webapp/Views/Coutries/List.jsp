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
	
	<a href="./Add.jsp">부서추가</a>
</body>
</html>