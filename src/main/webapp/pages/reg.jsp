<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>
        Registration page
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

