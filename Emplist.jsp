<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Employee  Application</title>
</head>
<body>
<center>
<h1>Employee Management</h1>
<h2>
<a href="new">Add New Employee</a>
&nbsp;&nbsp;&nbsp;
<a href="list">List All Employees</a>
</h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List of Employees</h2></caption>
<tr>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Salary</th>
<th>Actions</th>
</tr>
<c:forEach var="e" items="${listEmp}">
<tr>
<td><c:out value="${e.getID()}"/></td>
<td><c:out value="${e.getName()}" /></td>
<td><c:out value="${e.getAddress()}"/></td>
<td><c:out value="${e.getSalary()}"/></td>
<td>
<a href="edit?id=<c:out value='${e.getID()}' />">Edit</a>
<!-- <a href="edit" id=<c:out value="${e.getID()}"/>>Edit</a> -->
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?id=<c:out value='${e.getID()}'/>">Delete</a>
<!-- <a href="delete" id=<c:out value="${e.getID()}"/>>Delete</a> -->
</td>
</c:forEach>
</tr>
</table>
</div>
</body>
</html>
