<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
</head>
<body>
<p style="color:#15ff1c">${msg}</p><hr>
用户登录<br>
<form action="/user/login" method="post">
    用户名：<input type="text" name="name" /><br>
    密码：<input type="password" name="password" /><br>
    <input type="submit" value="提交"><br>
</form><hr>
用户注册<br>
<form action="/user/register" method="post">
    ID：<input type="text" name="id" /><br>
    用户名：<input type="text" name="name" /><br>
    密码：<input type="password" name="password" /><br>
    <input type="submit" value="提交"><br>
</form><hr>
修改密码<br>
<form action="/user/test" method="post">
    <input type="submit" value="提交"><br>
</form><hr>
</body>
</html>