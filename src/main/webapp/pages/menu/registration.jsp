<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
    <title>
        Регистрация
    </title>
</head>
<body>
<form action="/reg" method="post">
    Username: <input name="username"/>
    <br><br>
    Password: <input name="password"/>
    <br><br>
    Name: <input name="name"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form>
<p style="color:red;font-size: 24px">
    ${requestScope.message}
</p>
</body>
</html>