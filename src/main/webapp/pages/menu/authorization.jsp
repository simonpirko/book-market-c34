<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Авторизация
    </title>
</head>
<body>
<form action="/auth" method="post">
    Input username
    <input type="text" name="username">
    <br>
    Input password
    <input type="password" name="password">
    <p style="color:red;font-size: 24px">
        ${requestScope.wrongPassword}
    </p>
    <br>
    <button>Ok</button>
</form>
<p style="color:red;font-size: 36px">
    ${requestScope.userDoesntExist}
</p>
</body>
</html>