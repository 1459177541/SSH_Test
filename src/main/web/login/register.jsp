<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <div align="center">
        <form method="post" action="/registerTo">
            <label>
                用户名：<input type="text" name="name"/>
            </label><br/>
            <label>
                密码：<input type="password" name="password"/>
            </label><br/>
            <label>
                确认密码：<input type="password" name="password2"/>
            </label><br/>
            <label>
                邮箱：<input type="text" name="email"/>
            </label><br/>

            <label>类型：
                <select name="type">
                    <option value="学生">学生</option>
                    <option value="教师">教师</option>
                </select>
            </label> <br/>
            <input type="submit" value="注册">
        </form>
    </div>
</body>
</html>
