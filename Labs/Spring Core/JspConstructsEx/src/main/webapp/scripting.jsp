<%@page import="java.util.List,java.util.Arrays" %>
<html>
<body>
<h2>Hello World!</h2>
<!-- scripting tag -->
<%int a=10;
  int b=20;
  out.println(Math.pow(10,20));
%>
<!-- declaration tag -->
<%!
  int a=10;
  int b=20;
  List<String> countries = Arrays.asList("India","USA","Chaina");
%>
<!-- scripting tag -->
<p>Scriptlet: <% out.println(a+b); %></p>
<%
  out.println(a+b);
%>

<p>Expression:<%=(a+b)*10/b %></p>
</body>
</html>
