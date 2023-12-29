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
			부서ID <input type="text" name="department_id">
		</div>
		<div>
			부서명 <input type="text" name="department_name">
		</div>
		<div>
			부사장ID <input type="text" name="manager_id">
		</div>
		<div>
			주소ID <input type="text" name="location_id">
		</div>
		<button>추가</button>
		<button type="reset">초기화</button>
	</form>

</body>
</html>