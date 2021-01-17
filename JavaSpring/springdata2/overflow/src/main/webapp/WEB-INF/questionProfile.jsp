<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Gr0tto
  Date: 1/12/2021
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Profile</title>
</head>
<body>
<h1>${question.question}</h1>
<h3>Tags: <c:forEach items="${question.tags}" var="tag"><span>${tag.subject}</span> </c:forEach> </h3>
<table>
    <thead>
    <tr>
        <th>Answers</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${question.answers}" var="ans">
<tr>
    <td><c:out value="${ans.answer}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
<h3>Add your Answer</h3>
<form:form action="/questions/${question.id}" method="post" modelAttribute="answers">
    <p>
        <form:label path="answer">Answer</form:label>
        <form:errors path="answer"/>
        <form:textarea  path="answer"/>

    </p>
    <input type="submit" value="Answer it!"/>
</form:form>
</body>
</html>