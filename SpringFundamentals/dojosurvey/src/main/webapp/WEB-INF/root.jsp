<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/6/2021
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>Dojo Survey Index</title>
</head>
<body>
<div class="container">
    <div style="margin: 15%;border:2px solid gray;padding: 20px">
<form action="/login" method="post">
    <div class="form-group">
        <label>Your Name: </label>
        <input type="text" class="form-control" name="name" required>
    </div>
    <div class="form-group">
        <label>Location: </label>
        <select class="form-control" name="location">
            <option value="nablus">Nablus</option>
            <option value="ramallah">Ramallah</option>
            <option value="jenin">Jenin</option>
        </select>
    </div>
    <div class="form-group">
        <label>Favorite Language: </label>
        <select class="form-control" name="language">
            <option value="java">JAVA</option>
            <option value="python">PYTHON</option>
            <option value="c++">C++</option>
            <option value="javascript">JAVASCRIPT</option>
        </select>
    </div>
    <div class="form-group">
        <label>Comment(optional): </label>
        <textarea class="form-control" rows="3" name="comment"></textarea>
    </div>
    <br>
    <button>Button</button>
</form>
    </div>
</div>
</body>
</html>
