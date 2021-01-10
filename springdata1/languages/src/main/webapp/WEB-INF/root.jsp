<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/7/2021
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    <title>Languages</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td><a href="/languagess/${language.id}">Delete</a> <a href="/languages/${language.id}/edit">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Current Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    <input type="submit" value="Add Language"/>
</form:form>
</div>
</body>
</html>
