<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
    <title>
        Регистрация
    </title>
</head>
<body>
<form action="/reg" method="post">
    Login: <input name="login"/>
    <br>
    <p style="color:red;font-size: 24px">
    ${requestScope.usernameError}
    </p>
    <p style="color:red;font-size: 24px">
        ${requestScope.userExistError}
    </p>
    <br>
    Password: <input name="password"/>
    <br>
    <p style="color:red;font-size: 24px">
        ${requestScope.passwordError}
    </p>
    <br>
    Name: <input name="name"/>
    <br>
    <p style="color:red;font-size: 24px">
        ${requestScope.nameError}
    </p>
    <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>