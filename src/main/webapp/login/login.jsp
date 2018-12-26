<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div align="center">
        <%--<s:form method="POST">--%>
            <%--<s:textfield name="user.name" label="用户名"/>--%>
            <%--<s:password name="user.password" label="密码"/>--%>
            <%--<s:submit name="login" value="登录" action="login"/>--%>
            <%--<s:submit name="register" value="注册" action="registerView"/>--%>
        <%--</s:form>--%>
        <form method="post" action="/loginTo">
            <label>
                id：<input type="text" name="name"/>
            </label><br/>
            <label>
                密码：<input type="password" name="password"/>
            </label><br/>
            <label>类型：
                <select name="type">
                    <option value="学生">学生</option>
                    <option value="教师">教师</option>
                </select>
            </label> <br/>
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
