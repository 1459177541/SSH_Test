<%@ page import="entity.user.User" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18-10-16
  Time: 下午3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerSuccess</title>
</head>
<body>
    <h1 align="center">
        欢迎你，<%=((User)session.getAttribute("user")).getName()%>恭喜你注册成功!!
    </h1>
</body>
</html>
