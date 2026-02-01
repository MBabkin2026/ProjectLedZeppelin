<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Статистика игрока</title></head>
<body>
<h2>Статистика игрока ${stats.playerId}</h2>
<ul>
    <li>Всего игр: ${stats.totalGames}</li>
    <li>Побед: ${stats.wins}</li>
    <li>Поражений: ${stats.losses}</li>
    <li>Винрейт: <fmt:formatNumber value="${stats.winRate}" pattern="0.0"/>%</li>
</ul>
</body>
</html>