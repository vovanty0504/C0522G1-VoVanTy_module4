<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/13/2022
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="email">
    <table>
        <tr>
            <form:hidden path="id"/>
            <td><h4>Languages</h4></td>
            <td><form:select path="language" items="${language}"/></td>
        </tr>
        <tr>
            <td><h4>Page Size</h4></td>
            <td> Show<form:select path="pageSize" items="${pageSize}"/> Email per page</td>
        </tr>
        <tr>
            <td><h4>Spam Filter</h4></td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td><h4>signature </h4></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button> Update</form:button></td>
        </tr>
    </table>
</form:form>

</body>
</html>
