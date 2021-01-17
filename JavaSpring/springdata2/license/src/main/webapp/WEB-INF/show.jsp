<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Person</title>
</head>
<body>
<h1><c:out value="${license.person.firstName}"/>   <c:out value="${license.person.lastName}"/></h1>
<p>License number: <c:out value="${license.getNumberAsString()}" /></p>
<p>State: <c:out value="${license.state}" /></p>
<p>Expiration Date: <c:out value="${license.getDate()}" /></p>
<h4></h4>


</body>
</html>
