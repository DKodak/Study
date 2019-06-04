<%--
  Created by IntelliJ IDEA.
  User: Kodak
  Date: 2019/6/4 9:31
  Email:2270301642@qq.com
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="/addOrderPage" method="post">
            <input type="hidden" name="token" value="${token}">
            <span>订单名称</span>
            <input type="text" name="orderName"><br>
            <span>订单描述</span>
            <input type="text" name="orderDes"><br>
            <br>
            <input type="submit">
        </form>
</body>
</html>
