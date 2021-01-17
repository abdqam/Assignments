<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>Title <c:out value="${song.title}"/></p>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating: <c:out value="${song.rating}"/></p>
<a href="/delete/${song.id}">Delete</a>
</body>
</html>
