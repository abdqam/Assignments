<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/6/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Survey Index</title>
</head>
<body>
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
    <h1>Thank you <c:out value="${name}"/> for choosing <c:out value="${language}"/> as your favorite language</h1>
    <form action="/destroy">
        <button>Go Back!</button>
    </form>
</div>
</body>
</html>

</body>
</html>
