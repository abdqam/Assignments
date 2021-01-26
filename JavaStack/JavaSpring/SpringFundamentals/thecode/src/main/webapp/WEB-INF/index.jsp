<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/5/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Secret Code</title>
</head>
<body>
<c:out value="${error}"/>
<h1>What is the code?</h1>
<form action="/checkcode" method="POST">
    <input type="text" name="code">
    <input type="submit" value="Try code">

</form>
</body>
</html>
