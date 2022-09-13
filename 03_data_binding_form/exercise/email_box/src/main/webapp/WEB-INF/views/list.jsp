<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/13/2022
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<table border="1" style="width: 30%;height: 30%">
    <h3 style="color: brown">${mess}</h3>
    <tr>
        <th>SST</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
        <th>Thông tin</th>
    </tr>
    <c:forEach items="${emailList}" var="email" varStatus="em">
        <tr>
            <td>${em.count}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamFilter}</td>
            <td>${email.signature}</td>
            <td> <button><a href="/update?id=${email.id}">update</a></button></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
