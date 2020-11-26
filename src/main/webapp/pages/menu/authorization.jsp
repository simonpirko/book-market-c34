<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Авторизация
    </title>
</head>
<body>
<form action="/auth" method="post">
    Input login
    <input type="text" name="login">
    <br>
    Input password
    <input type="password" name="password">
    <br>
    <button>Ok</button>
</form>
<p style="color:red;font-size: 24px">
    ${requestScope.message}
</p>
</body>
</html>