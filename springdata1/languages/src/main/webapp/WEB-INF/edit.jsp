<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/9/2021
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>${language.name}</title>
    <style>div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
        width:48%;
        margin-left:25%;
        margin-top:2%;
    }
    input[type=submit] {
        width: 100%;
        background-color: #4c94af;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type=submit]:hover {
        background-color: #437588;
    }
    input[type=text] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    span{
        color:red;
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

<div>
<a href="/languagess/${language.id}" class="btn">Delete</a><a href="/languages" class="btn" style="margin-left:2%">Dashboard</a>

<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
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
    <input type="submit" value="Update"/>
</form:form>
</div>
</body>
</html>
