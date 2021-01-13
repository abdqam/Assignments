<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Gr0tto
  Date: 1/12/2021
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Dashboard</title>
</head>
<body>
<table>
    <thead>
    <tr>
    <th>Question</th>
    <th>Tags</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="question">
        <tr><td><a href="/questions/${question.id}">${question.question}</a></td>
        <c:forEach items="${question.tags}" var="tag">
            <td>${tag.subject},<td>
        </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
