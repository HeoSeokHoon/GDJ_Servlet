<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Departments Add</h1>
	
	<form action="./AddProcess.jsp">
		<div>
			나라ID <input type="text" name="country_id">
		</div>
		<div>
			나라명 <input type="text" name="country_name">
		</div>
		<div>
			대륙ID <input type="text" name="region_id">
		</div>
		<button>추가</button>
		<button type="reset">초기화</button>
	</form>

</body>
</html>