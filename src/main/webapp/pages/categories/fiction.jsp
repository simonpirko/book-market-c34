<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Художественная литература</title>
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

        div.menu{
            margin: 0 10px 10px 0;
            padding: 50px 100px;
            text-align: left;
            display: inline-block;
            vertical-align: top;
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
</div>
<div id="content">
    <h1 align="center" style="color: darkgreen; border-bottom: 2px solid darkgreen;">Книжный магазин -> Художественная литература</h1>
<br><br>
<form action="/book" method="post">
<c:forEach var="elem" items="${sessionScope.all}">
    <label><b>Наименование: </b> <c:out value="${elem.name}"/></label>
    <label> <b>Автор:</b> <c:out value="${elem.author}"/> </label>
    <label><b>Формат: </b><c:out value="${elem.format}"/></label>
    <label><b>Издательство:</b> <c:out value="${elem.publisher}"/></label>
    <label><b>Год издания:</b> <c:out value="${elem.publicationDate}"/></label>
    <label><b>Количество страниц:</b> <c:out value="${elem.pages}"/></label>
    <label><b>Жанр: </b><c:out value="${elem.genre}"/></label>
    <label><b>Цена:</b> <c:out value="${elem.cost}"/></label>
    <label><b>Статус: </b><c:out value="${elem.bookStatus}"/></label>
    <label><b>Описание:</b> <c:out value="${elem.description}"/></label>
    <br><button >Заказать</button>
    <hr color="darkgreen">
</c:forEach>

</form>
</div>
<footer  class="footer">
   <br>
   <p align="center">© 2020, Минск Совместный проект C34/Java TMS</p>
</footer>

</body>
</html>
</body>
</html>
