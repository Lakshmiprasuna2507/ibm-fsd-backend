<%@page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>

</head>
<body>
<form action="update.do?id=<%= request.getParameter("id") %>">
<table>
<h2>Employee Edit</h2>
<tr><td>Employee Name:<input type="text" name="name"  value="<%=request.getParameter("name")%>"/></td></tr>
<tr><td>Employee Gender:</td><td><input type="radio" name="gender" value="male"/>Male<input type="radio" name="gender" value="female"/>Female </td></tr> 
<tr><td>Employee Age<input type="number" name="age" value="<%=request.getParameter("age")%>"/></td></tr>
<tr><td>Employee Designation:<input type="text" name="designation" value="<%=request.getParameter("designation")%>"/></td></tr>
<tr><td>Employee Department:<input type="text" name="department" value="<%=request.getParameter("department")%>"/></td></tr>
<tr><td>Employee Country:<input type="text" name="country" value="<%=request.getParameter("country")%>"/></td></tr>
<tr><td><input type="submit" value="update"/></td></tr>
</table>
</form>
</body>
</html>