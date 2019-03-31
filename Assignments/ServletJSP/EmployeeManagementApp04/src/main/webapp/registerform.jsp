<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%
String name=request.getParameter("name");
String age=request.getParameter("age");
String gender=request.getParameter("gender");
String employee=request.getParameter("employee");
String skills=request.getParameter("skills");
String designation=request.getParameter("designation");
String department=request.getParameter("department");
String address=request.getParameter("address");
String country=request.getParameter("country");
out.println("welcome"+name);
out.println(name+"registered successfully");

%>
<a href="login.jsp">back</a>
</body>
</html>