<%@ page import="entity.user.User" %>
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
