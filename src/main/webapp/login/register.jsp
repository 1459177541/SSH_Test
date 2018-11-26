<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18-10-16
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <div align="center">
        <s:form action="register" method="POST">
            <s:textfield name="user.name" label="用户名"/>
            <s:password name="user.password" label="密码"/>
            <s:password name="password" label="确认密码"/>
            <s:textfield name="user.email" label="邮箱"/>
            <s:submit label="注册"/>
        </s:form>
    </div>
</body>
</html>
