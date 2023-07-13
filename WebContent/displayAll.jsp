<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>This is title</title>
<style>
table, tr, td, th {
	border: 1px solid gray;
	border-collapse: collapse;
}

th {
	background-color: black;
	color: white;
}

th, td {
	padding: 8px;
}

table {
	width: 50%;
	margin: auto;
}
</style>
</head>

<body>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
		</tr>

		<c:forEach items="${emplist}" var="e">
			<tr>
				<td>${e.id }</td>
				<td>${e.name }</td>
				<td>${e.age }</td>
			</tr>
		</c:forEach>

	</table>
</body>

</html>