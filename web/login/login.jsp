<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18-10-11
  Time: 下午6:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div align="center">
        <s:form action="login" method="POST">
            <s:textfield name="user.name" label="用户名"/>
            <s:password name="user.password" label="密码"/>
            <s:submit label="登录"/>
        </s:form>
    </div>
</body>
</html>
