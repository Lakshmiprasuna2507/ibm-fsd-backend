<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="home.jsp"></jsp:include>
</head>
<body>
<%
String username=request.getParameter("username");

String password=request.getParameter("password");

out.println("welcome "+username);
%>

</body>
</html>
