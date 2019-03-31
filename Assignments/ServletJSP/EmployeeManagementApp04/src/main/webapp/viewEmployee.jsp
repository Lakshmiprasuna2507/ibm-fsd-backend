<%@page
	import="com.examples.java.jsp.employeemanagement.EmployeeService"%>
<%@page
	import="java.util.Map,com.examples.java.jsp.employeemanagement.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list employee</title>
<style type="text/css">
table, td, th {
	border: 2px solid;
}
</style>
</head>
<body>
	<%
		EmployeeService emp = new EmployeeService();
		Map<Integer, Employee> employee = emp.viewEmployee();
		HttpSession ses = request.getSession();
	%>
	<table>
		<tr>
			<th>EmployeeId</th>
			<th>EmployeeName</th>
			<th>EmployeeGender</th>
			<th>EmployeeAge</th>
			<th>EmployeeDesignation</th>
			<th>EmployeeDepartment</th>
			<th>EmployeeCountry</th>
			<th>Action</th>
		</tr>

		<%
			for (Employee e : employee.values()) {
				
		%>
		<tr>
			<td><%=e.getEmpId()%></td>
			<td><%=e.getEmpName()%></td>
			<td><%=e.getGender()%></td>
			<td><%=e.getAge()%></td>
			<td><%=e.getDesignation()%></td>
			<td><%=e.getDepartment()%></td>
			<td><%=e.getCountry()%></td>
			<td><a href="upadateEmployee.jsp?id=<%=e.getEmpId()%>&name=<%=e.getEmpName()%>&gender=<%=e.getGender()%>&age=<%=e.getAge()%>&designation=<%=e.getDesignation()%>&department=<%=e.getDepartment()%>&designation=<%=e.getDesignation()%>&country=<%=e.getCountry()%>">Edit</a>
				<a href="delete.do?did=<%=e.getEmpId()%>">Delete</a></td>

		</tr>
		<% 
}
%>
	</table>
</body>
</html>