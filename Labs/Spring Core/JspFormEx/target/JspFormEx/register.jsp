<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>employee registration form</title>

</head>
<body>
 <form action="register.do">
<table> 
<h2>Employee Registration</h2> 
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>  
<tr><td>Age:</td><td><input type="number" name="age"/></td></tr>    
<tr><td>Gender:</td><td>  
<input type="radio" name="gender" value="male"/>Male   
<input type="radio" name="gender" value="female"/>Female </td></tr> 
<tr><td>Employee:</td><td>
<input type="checkbox" name="emp" value="employee"/></td></tr>
<tr><td>Skills:</td><td>
<select name="skills" style="width:155px">  
<option>C</option>  
<option>C++</option>  
<option>JAVA</option>  
<option>JSP</option>  
<option>Springs</option>  
<option>Other</option>
</select>
</td></tr>
<tr><td>Designation:</td><td><input type="text" name="designation"/></td></tr>
 <tr><td>Department:</td><td><input type="text" name="department"/></td></tr>
 <tr><td>Address:</td><td><input type="text" name="address"/></td></tr>
<tr><td>Country:</td><td>  
<select name="country" style="width:155px">  
<option>India</option>  
<option>Pakistan</option>  
<option>Afghanistan</option>  
<option>Berma</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="register"/></td></tr>  
</table>  
</form>  
</body>
</html>