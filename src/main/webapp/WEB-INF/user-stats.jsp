<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Статистика пользователя</title></head>
<body>
<h2>Профиль: ${user.login}</h2>

<div>
    <p>Всего игр: ${user.stats.totalGames}</p>
    <p>Побед: ${user.stats.wins}</p>
    <p>Поражений: ${user.stats.losses}</p>
    <p>Винрейт: <c:out value="${String.format('%.1f', user.stats.winRate)}"/>%</p>
</div>

<a href="${pageContext.request.contextPath}/user-list">Назад к списку</a>
</body>
</html>