<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/13/2022
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tờ khai y tế</h1><br>

<p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM</p>

<p style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>

<form:form action="/create" modelAttribute="medicalDeclaration" method="post">
    <p>Họ và tên(ghi chữ IN HOA)</p>
    <form:input size="100%" path="name"/>

    <table style="width: 100%">
        <tr>
            <td>Năm sinh</td>
            <td>Giới tính</td>
            <td>Quốc tịch</td>
        </tr>
        <tr>
            <td>
                <form:select cssStyle="width: 33%" path="dayOfBirth"/>
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="gender" />
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="country"/>
            </td>
        </tr>
    </table>

    <p>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</p>
    <form:input size="100%" path="idCard"/>

    <p>Thông tin đi lại</p>
    <form:radiobuttons path="travelInformation" items="${travelInformationList}"/>

    <table style="width: 100%">
        <tr>
            <td>Số hiệu phương tiện</td>
            <td>Số ghế</td>
        </tr>
        <td>
            <form:input cssStyle="width: 50%" path="license"/>
        </td>
        <td>
            <form:input cssStyle="width: 50%" path="numberOfSeat"/>
        </td>
    </table>

    <table style="width: 100%">
        <tr>
            <td colspan="3">Ngày khởi hành</td>
            <td colspan="3">Ngày kết thúc</td>
        </tr>
        <td>
            <form:select cssStyle="width: 33%" path="startDay" />
        </td>
        <td>
            <form:select cssStyle="width: 33%" path="endDay"/>
        </td>

    </table>
    <p>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</p>
    <form:textarea size="100%" path="travelHistory"/>

    <p style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo
        quốc gia về Phòng chống dịch Covid-19.</p>
    <p style="color: red">Khi bạn nhấn nút"Gửi" là bạn đã hiểu và đồng ý</p>

    <button type="submit">Gửi tờ khai</button>
</form:form>
</body>
</html>
