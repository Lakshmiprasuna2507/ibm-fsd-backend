
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="home.jsp"></jsp:include>
<jsp:include page="viewEmployee.jsp"></jsp:include>

</head>
<body>
<%
String username=request.getParameter("username");

String password=request.getParameter("password");

out.println("welcome "+username);
%>

<a href="addemployee.jsp">Add Employee</a>

</body>
</html>