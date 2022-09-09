<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/9/2022
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/conversion" method="get">
    <input type="text" name="money" placeholder="Nhập USD">
    <button type="submit">Kết quả</button>
    <input type="text" value="${result}" disabled> (VND)

</form>
</body>
</html>
