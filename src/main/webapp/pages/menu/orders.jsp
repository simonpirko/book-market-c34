<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>
        Мои заказы
    </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <style>
        #content {
            float: right ;
            width: 80% ;
            padding-right: 30px;
            padding-top: 50px;
        }
        #navbar {
            float: left;
            width: 15%;
        }

        img.menu{
            width: 120px;
            height: 100px;
            align-content: center;
        }

        .menuBorder a:hover {
            background: SpringGreen;
        }

        .name h1{
            color: darkgreen;
            border-bottom: 2px solid darkgreen;
        }

        .footer {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 50px;
            background-color:PaleTurquoise

        }

    </style>
<body style="background-color: lightcyan">
<div class="menuBorder">
    <div id="navbar">
        <ul class="nav flex-column">
            <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                <a href="/index" style="text-decoration: none;">
                    <img src = "https://static.tildacdn.com/tild6434-3134-4737-a364-336562393638/Tucson-Storytimes.jpg" alt = "logo" width="202" height="115">
                </a>
            </li>
            <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                <a class="nav-link" href="/index" style="color: black;">Главная</a>
            </li>
            <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                <a class="nav-link" href="/pages/menu/about.jsp" style="color: black;">О компании</a>
            </li>
            <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                <a class="nav-link" href="/pages/menu/help.jsp" style="color: black;">Помощь</a>
            </li>
            <c:if test="${requestScope.regVisibility}">
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/reg" style="color: black;">Регистрация</a>
                </li>
            </c:if>
            <c:if test="${requestScope.authVisibility}">
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/auth" style="color: black;">Авторизация</a>
                </li>
            </c:if>
            <c:if test="${requestScope.profileMenuVisibility}">
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pro" style="color: black;">Профиль</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pages/menu/orders.jsp" style="color: black;">Мои заказы</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pages/menu/goods.jsp" style="color: black;">Купленные товары</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pages/menu/comments.jsp" style="color: black;">Мои отзывы</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pages/menu/discount.jsp" style="color: black;">Моя скидка</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pages/menu/select.jsp" style="color: black;">Избранное</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/pages/menu/basket.jsp" style="color: black;">Корзина</a>
                </li>
                <li class="nav-item"
                    style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
                    <a class="nav-link" href="/logout" style="color: black;">Выйти</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
<div id="content">
    <h1 align="center" style="color: darkgreen; border-bottom: 2px solid darkgreen;">Книжный магазин -> Мои заказы</h1>
</div>
<br><br><br>

<footer style = "background-color:PaleTurquoise; height:50px">
    <br>
    <p align="center">© 2020, Минск Совместный проект C34/Java TMS</p>
</footer>

</body>
</html>