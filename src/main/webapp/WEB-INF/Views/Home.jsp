<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<table>
		<tr>
			<td>
				<button id="reg">REGION</button>
			</td>
			<td>
				<button id="dep">DEPARTMENTS</button>
			</td>
			<td>
				<button id="cou">COUNTRIES</button>
			</td>
			<td>
				<button id="emp" disabled="disabled">EMPLOYEES</button>
			</td>
			<td>
				<button id="loc" disabled="disabled">LOCATION</button>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
		let reg = document.getElementById("reg");
		let dep = document.getElementById("dep");
		let cou = document.getElementById("cou");
		let emp = document.getElementById("emp");
		let loc = document.getElementById("loc");
		reg.addEventListener("click", function(){
			window.location.href="./Regions/List.jsp"
			console.log("1");
		});
		dep.addEventListener("click", function(){
			window.location.href="./Departments/List.jsp"
		});
		cou.addEventListener("click", function(){
			window.location.href="./Countries/List.jsp"
		});
		emp.addEventListener("click", function(){
			//window.location.href=".//List.jsp"
		});
		loc.addEventListener("click", function(){
			//window.location.href=".//List.jsp"
		});
	</script>
</body>
</html>