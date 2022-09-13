<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/13/2022
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body>
  <h1> Thông tin khai báo</h1>
<%--  <h3 style="color: blue">${message}</h3>--%>
  <a href="/create">
    <button class="btn btn-info">
      Thêm mới
    </button>
  </a>
  <table class="table">
    <tr>
      <th>Họ tên</th>
      <th>Năm sinh</th>
      <th>Giới tính</th>
      <th>Quốc tịch</th>
      <th>Số CMND(Căn cước)/Hộ chiếu</th>
      <th>Thông tin đi lại</th>
      <th>Số hiệu phương tiện</th>
      <th>Số ghế</th>
      <th>Ngày khởi hành</th>
      <th>Ngày Kết thúc</th>
      <th>Lịch sử đi lại</th>
      <th></th>
    </tr>
    <c:forEach items="${medicalDeclarationList}" var="list">
      <tr>
        <td>${list.name}</td>
        <td>${list.dayOfBirth}</td>
        <td>${list.gender}</td>
        <td>${list.country}</td>
        <td>${list.idCard}</td>
        <td>${list.travelInformation}</td>
        <td>${list.license}</td>
        <td>${list.numberOfSeat}</td>
        <td>${list.startDay}</td>
        <td>${list.endDay}</td>
        <td>${list.travelHistory}</td>
      </tr>
    </c:forEach>
  </table>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
  </body>
</html>
