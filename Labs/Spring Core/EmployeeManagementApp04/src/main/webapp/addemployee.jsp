
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add employee</title>

</head>
<body>
<form action="add.do">
<table>
<h2>Add Employee</h2>
<tr><td>Employee ID:</label><input type="number" name="id"/></td></tr>
<tr><td>Employee Name:</label><input type="text" name="name"/></td></tr>
<tr><td>Gender:</label>
<div>
  <input type="radio" name="gender" value="male"> Male
  <input type="radio" name="gender" value="female"> Female
  </div></td></tr>
<tr><td>Employee Age:</label><input type="number" name="age"/></td></tr>
<tr><td>Designation:</label><input type="text" name="designation"/></td></tr>
<tr><td>Department:</label><input type="text" name="department"/></td></tr>
<tr><td>Country:</label><input type="text" name="country"/></td></tr>
<input type="submit" value="addEmployees">
</table>
</form>

</body>
</html>