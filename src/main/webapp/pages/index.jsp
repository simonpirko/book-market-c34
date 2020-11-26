<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<p align="center">
    <img src="pics/calc.jpg" width="500" height="500" alt=""/>
    <form action="/main" method="post">
<p align="center">
    Choose your action
    <c:if test="${requestScope.flag1}">
        <a href="/reg">Registrate</a>
    </c:if>
    <c:if test="${requestScope.flag2}">
        <a href="/auth">Authorize</a>
    </c:if>
    <c:if test="${requestScope.flag3}">
        <a href="/logout">Logout</a>
    </c:if>
</p>
</form>
</body>
</html>
