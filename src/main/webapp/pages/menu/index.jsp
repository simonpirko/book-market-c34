<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>
       Книжный магазин
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

    div.menu{
        width: 250px;
        margin: 0 10px 10px 0;
        padding: 10px 0;
        text-align: left;
        display: inline-block;
        vertical-align: top;
    }
    .menuBorder a:hover {
        background: SpringGreen;
        }

    .name h1{
        color: darkgreen;
        border-bottom: 2px solid darkgreen;
    }

    </style>
<body style="background-color: lightcyan">
<div class="menuBorder">
<div id="navbar">
<ul class="nav flex-column">
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a href="/pages/menu/index.jsp" style="text-decoration: none;">
            <img src = "https://static.tildacdn.com/tild6434-3134-4737-a364-336562393638/Tucson-Storytimes.jpg" alt = "logo" width="202" height="115">
        </a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/about.jsp" style="color: black;">О компании</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/help.jsp" style="color: black;">Помощь</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/registration.jsp" style="color: black;">Регистрация</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/authorization.jsp" style="color: black;">Авторизация</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/profile.jsp" style="color: black;">Профиль</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/orders.jsp" style="color: black;">Мои заказы</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/goods.jsp" style="color: black;">Купленные товары</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/comments.jsp" style="color: black;">Мои отзывы</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/discount.jsp" style="color: black;">Моя скидка</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/select.jsp" style="color: black;">Избранное</a>
    </li>
    <li class="nav-item" style="border-bottom: 1px solid darkgreen; border-top: 1px solid darkgreen;background:LightCyan">
        <a class="nav-link" href="/pages/menu/basket.jsp" style="color: black;">Корзина</a>
    </li>
</ul>
</div>
<div id="content">
    <h1 align="center" style="color: darkgreen; border-bottom: 2px solid darkgreen;">Книжный магазин</h1>
    <br><br><br>
    <form class="form-inline" style="align-content: center">
        <input class="form-control mr-sm-2" type="search"  aria-label="Search" placeholder="Я хочу найти" style=" display: inline-block; margin-left: 30% ;width:300px;">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style=" display: inline-block;  width:100px;">Поиск</button>
    </form>
</div>
</div>
<br><br><br>
<div>
    <div class="menu" style="padding-left: 40px">
        <img class="menu" src="https://avatars.mds.yandex.net/get-districts/403922/2a00000165c3825223d9aa2eb6455de40bf0/optimize">
        <h4>Развлечения</h4>
        <ul>
        <li class="nav-item">
            <a class="nav-link" href="/pages/.jsp" style="color: black;">Настольные игры</a>
        </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Наборы для творчества</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Рисование</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Книги для творчества</a>
            </li>
        </ul>
    </div>

    <div class="menu">
        <img class="menu" src="https://img1.goodfon.ru/original/3000x1949/8/83/knigi-oblozhki-zakladka-doska.jpg">
        <h4>Книги</h4>
        <ul>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Художественная литература</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Учебная литература</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Детская литература</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Бизнес-литература</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Нехудожественная литература</a>
            </li>
        </ul>
    </div>

    <div class="menu">
        <img class="menu" src="https://www.culture.ru/storage/images/58a6d8c1cb971eb0c89d1d6aac9e9843/44772ba147f87f0e5f252557e9dbc0be.jpeg">
        <h4>Сувениры</h4>
        <ul>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Белорусские сувениры</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Сувениры для праздников</a>
            </li>
        </ul>
    </div>

    <div class="menu">
        <img class="menu" src="https://a3-market.ru/images/Kanctovary.jpg">
        <h4>Канцтовары</h4>
        <ul>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Бумажные принадлежности</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Рисование, письмо</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pages/.jsp" style="color: black;">Канцелярские мелочи</a>
            </li>
        </ul>
    </div>
</div>
</body>
<footer style = "background-color:PaleTurquoise; height:50px">
    <br>
    <p align="center">© 2020, Минск Совместный проект C34/Java TMS</p>
</footer>
</html>
