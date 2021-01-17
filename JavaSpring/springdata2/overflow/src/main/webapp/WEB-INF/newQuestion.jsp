<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Gr0tto
  Date: 1/12/2021
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Question</title>
</head>
<body>
<h1>What is your question?</h1>
<form:form action="/questions/new" method="post" modelAttribute="newquestion">
    <p>
        <form:label path="question">Question: </form:label>
        <form:errors path="question"/>
        <form:textarea path="question"/>
    </p>
    <form:form action="/questions/new" method="post" modelAttribute="tag">
    <p>
        <form:label path="subject">Tags</form:label>
        <form:errors path="subject"/>
        <form:input  path="subject"/>

    </p>
    <input type="submit" value="Submit"/>
    </form:form>
</form:form>
</body>
</html>
