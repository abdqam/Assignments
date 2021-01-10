<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/9/2021
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    <title>${language.name}</title>
    <style>
        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            width:48%;
            margin-left:25%;
            margin-top:2%;
        }
        .btn{
            padding: 1%;
            background-color: 4c94af;
            border-radius: 5px;
            text-decoration: none;
            color: white;
        }
        .btn:hover{
            background-color: #437588;
        }
    </style>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<a href="/languages" class="btn">Dashboard</a>
<h1><c:out value="${language.name}"/></h1>
<p>Description: <c:out value="${language.creator}"/></p>
<p>Language: <c:out value="${language.currentVersion}"/></p>
<a href="/languages/${language.id}/edit" class="btn">Edit Book</a>
<a href="/languagess/${language.id}" class="btn">Delete</a>
</div>
</body>
</html>