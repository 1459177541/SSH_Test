<%@ page import="java.util.Date" %>
<%@ page import="entity.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>
    <div class="center">
        <h1>
            Hello,
            <%
                User user = (User)session.getAttribute("user");
                out.print(user != null ? user.getName() : "World");
            %>
        </h1>
        现在是：<%=new Date()%><a href="login/login.jsp">登陆>>></a>
    </div>
</body>
</html>
