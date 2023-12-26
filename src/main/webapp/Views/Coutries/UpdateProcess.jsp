
<%@page import="com.forest.app.countries.CountriesDTO"%>
<%@page import="com.forest.app.countries.CountriesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	CountriesDAO cDao = new CountriesDAO();
	CountriesDTO cD = new CountriesDTO();
	
	cD.setCountry_id(request.getParameter("country_id"));
	cD.setCountry_name(request.getParameter("country_name"));
	cD.setRegion_id(Integer.parseInt(request.getParameter("region_id")));
	
	int result = cDao.update(cD);

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
		
		location.href="./Detail.jsp?country_id=<%= request.getParameter("country_id")%>";
	</script>
</body>
</html>