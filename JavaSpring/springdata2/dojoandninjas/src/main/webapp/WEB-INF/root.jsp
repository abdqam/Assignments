<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo app</title>
</head>
<body>
<h1>Welcome to our Dojo's App</h1>
<a href="/dojos/new">Add Dojo</a>
<a href="/ninjas/new">Add Ninja</a>
<table>
    <thead>
    <tr>
        <th>Dojo ID</th>
        <th>Dojo Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dojos}" var="dojo">
        <tr>
        <td>${dojo.id}</td>
        <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
