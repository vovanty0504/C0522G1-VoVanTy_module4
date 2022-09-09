<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/9/2022
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Dictionary$</title>
</head>
<body>
<h1>English - Vietnamese word lookup</h1>
<form action="/dictionary" method="get">
  <input name="eng" type="text" placeholder="input">
  <button type="submit">Search</button>
  <h4 >${result}</h4>
</form>
</body>
</html>
