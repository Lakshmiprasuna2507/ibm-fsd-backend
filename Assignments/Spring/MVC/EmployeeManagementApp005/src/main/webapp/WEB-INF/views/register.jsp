<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add Employee</title>
</head>

<style>


.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

<spring:url value="/" var="contextPath" htmlEscape="true" />



<body>


	<h2>Register Employee</h2>
	<form:form method="POST" action="registers" modelAttribute="user">

		<table>
			<tr>
				<td><form:label path="userName">UserName:</form:label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Age:</form:label></td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<%-- 			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="M" /> Male &nbsp; <form:radiobutton
						path="gender" value="F" /> Female</td>
			</tr> --%>

			<tr>
				<td>Gender:</td>
				<td><form:radiobuttons path="gender" items="${genderOptions}" />
					&nbsp;</td>
					<td><form:errors path="gender" cssClass="error" /></td>
			</tr>






			<tr>
				<td><form:label path="country">Country:</form:label></td>
				<td><form:select path="country" items="${countries}" /></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="passWord">Password:</form:label></td>
				<td><form:input path="passWord" /></td>
				<td><form:errors path="passWord" cssClass="error" /></td>
			</tr>

			<tr height="50">
				<td />
				<td><input type="submit" value="Save" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Reset" /> &nbsp;&nbsp;&nbsp;&nbsp; <a
					href="${contextPath}/login">Back</a></td>

			</tr>
		</table>
	</form:form>
</body>
</html>
