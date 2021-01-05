<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/5/2021
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current visit count</title>
</head>
<body>
<h3>You have visited <a href="/your_server">http://your_server/</a> <%=session.getAttribute("count")%> times.</h3>
<h3><a href="/your_server">Test another visit?</a></h3>
<form action="/your_server/destroy">
    <button>Reset</button>
</form>
</body>
</html>
