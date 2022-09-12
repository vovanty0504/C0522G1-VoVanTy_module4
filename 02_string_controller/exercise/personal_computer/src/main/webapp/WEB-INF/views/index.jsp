<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/12/2022
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<form action="calculate">
    <input name="number1" value="${number1}" placeholder="input number">
    <input name="number2" value="${number2}" placeholder="input number"> <br> <br>
    <button type="submit" value="+" name="calculation">Addition(+)</button>
    <button type="submit" value="-" name="calculation">Subtraction(-)</button>
    <button type="submit" value="/" name="calculation">Multiplication(X)</button>
    <button type="submit" value="*" name="calculation">Division(%)</button>
    <br> <br>
    <div>Kết Quả: ${result}</div>
</form>
</body>
</html>
