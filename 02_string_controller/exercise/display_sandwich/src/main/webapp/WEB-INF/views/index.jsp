<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/12/2022
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1 style="color: brown">Sandwich Condiments </h1>
<form action="/save" method="get">
    <input type="checkbox" value="lettuce" name="condiment"> <b>lettuce</b>
    <input type="checkbox" value="tomato" name="condiment"> <b>tomato</b>
    <input type="checkbox" value="mustard" name="condiment"> <b>mustard</b>
    <input type="checkbox" value="sprouts" name="condiment"> <b>sprouts</b> <br>
    <hr>
    <button type="submit">Save</button>

    <c:forEach var="sandwich" items="${sandwich}">
        <p>${sandwich}</p>
    </c:forEach>
</form>
</body>
</html>
