<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>UFO quest</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
          crossorigin="anonymous">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            max-width: 700px;
            margin: 40px auto;
            padding: 20px;
            line-height: 1.6;
        }
        #story {
            margin-top: 30px;
            padding: 25px;
            border: 2px solid #3498db;
            border-radius: 10px;
            background-color: #f0f8ff;
            min-height: 150px;
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 20px;
        }
        p {
            margin: 12px 0;
            color: #2c3e50;
        }
        strong {
            color: #e74c3c;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>UFO quest — это UFO quest</h1>

<div id="story">
    <c:choose>


        <c:when test="${progress.step == 'start'}">
            <p>Ты потерял память.</p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <button type="submit" name="action" value="accept" class="btn btn-success">Принять вызов</button>
                <button type="submit" name="action" value="decline" class="btn btn-danger">Отклонить вызов</button>
            </form>
        </c:when>


        <c:when test="${progress.step == 'accept'}">
            <p>Ты принял вызов.</p>
            <p>Поднимаешься на мостик к капитану?</p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <button type="submit" name="action" value="goUp" class="btn btn-primary">Подняться на мостик</button>
                <button type="submit" name="action" value="refuse" class="btn btn-secondary">Отказаться подниматься</button>
            </form>
        </c:when>


        <c:when test="${progress.step == 'decline'}">
            <p>Ты отклонил вызов.</p>
            <p><strong>Поражение.</strong></p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <input type="hidden" name="action" value="restart" />
                <button type="submit" class="btn btn-warning">Начать заново</button>
            </form>

            <a href="${pageContext.request.contextPath}/user-list"
               class="btn btn-outline-secondary mt-2">
                Назад к списку
            </a>
        </c:when>


        <c:when test="${progress.step == 'refuse'}">
            <p>Ты не пошёл на переговоры.</p>
            <p><strong>Поражение.</strong></p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <input type="hidden" name="action" value="restart" />
                <button type="submit" class="btn btn-warning">Начать заново</button>
            </form>

            <a href="${pageContext.request.contextPath}/user-list"
               class="btn btn-outline-secondary mt-2">
                Назад к списку
            </a>
        </c:when>


        <c:when test="${progress.step == 'goUp'}">
            <p>Ты поднялся на мостик.</p>
            <p>Рассказать правду о себе или солгать?</p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <button type="submit" name="action" value="tellTruth" class="btn btn-info">Рассказать правду</button>
                <button type="submit" name="action" value="lie" class="btn btn-danger">Солгать</button>
            </form>
        </c:when>


        <c:when test="${progress.step == 'tellTruth'}">
            <p>Ты рассказал правду.</p>
            <p>Капитан поверил и помог восстановить память.</p>
            <p>Тебя вернули домой.</p>
            <p><strong>Победа!</strong></p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <input type="hidden" name="action" value="restart" />
                <button type="submit" class="btn btn-success">Начать заново</button>
            </form>

            <a href="${pageContext.request.contextPath}/user-list"
               class="btn btn-outline-secondary mt-2">
                Назад к списку
            </a>
        </c:when>


        <c:when test="${progress.step == 'lie'}">
            <p>Ты солгал.</p>
            <p>Твою ложь разоблачили.</p>
            <p><strong>Поражение.</strong></p>
            <form method="post" action="${pageContext.request.contextPath}/quest?userId=${userId}">
                <input type="hidden" name="action" value="restart" />
                <button type="submit" class="btn btn-warning">Начать заново</button>
            </form>

            <a href="${pageContext.request.contextPath}/user-list"
               class="btn btn-outline-secondary mt-2">
                Назад к списку
            </a>
        </c:when>

    </c:choose>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>
</body>
</html>