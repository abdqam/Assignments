<%--
  Created by IntelliJ IDEA.
  User: Gr0tto
  Date: 1/14/2021
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome, <c:out value="${user.email}" /></h1>
<a href="/logout">Logout</a>
</body>
</html>