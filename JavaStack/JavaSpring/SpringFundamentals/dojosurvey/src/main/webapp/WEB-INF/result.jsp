<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/6/2021
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Survey Index</title>
</head>
<body>
<div style="margin: 15%;border:2px solid gray;padding: 20px">
<h1> Submitted Info</h1>
<h2> Name:     <c:out value="${name}"/> </h2>
<h2> location: <c:out value="${location}"/> </h2>
<h2> Language: <c:out value="${language}"/> </h2>
<h2> comment:  <c:out value="${comment}"/> </h2>
<form action="/destroy">
    <br>
    <button>Go Back!</button>
</form>
</div>
</body>
</html>
