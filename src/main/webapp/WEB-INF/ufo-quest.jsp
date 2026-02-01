<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty param.userId}">
    <c:redirect url="/user-list"/>
</c:if>


<html>
<head>
    <title>UFO quest</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            line-height: 1.6;
        }
        .button {
            display: inline-block;
            margin: 10px 5px;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #45a049;
        }
        #story {
            margin-top: 20px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

<h1>UFO Quest (Пользователь #${userId})</h1>
<p>Ты потерял память.</p>

<div id="optional-container">
    <button type="button" class="button" onclick="choose('accept')">Принять вызов</button>
    <button type="button" class="button" onclick="choose('decline')">Отклонить вызов</button>

    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/quest-list?userId=${userId}"
           class="btn btn-outline-secondary">
            ← Выбрать другой квест
        </a>
    </div>

    <a href="${pageContext.request.contextPath}/user-list"
       class="btn btn-outline-secondary mt-2">
        Назад к списку
    </a>


</div>

<div id="story"></div>

<script>
    const storyDiv = document.getElementById('story');

    function choose(choice) {
        switch (choice) {
            case 'accept':
                storyDiv.innerHTML = `
                        <p>Ты принял вызов.</p>
                        <p>Поднимаешься на мостик к капитану?</p>
                        <button type="button" class="button" onclick="choose('goUp')">Подняться на мостик</button>
                        <button type="button" class="button" onclick="choose('refuse')">Отказаться подниматься на мостик</button>
                    `;
                break;

            case 'decline':
                storyDiv.innerHTML = `
                        <p>Ты отклонил вызов.</p>
                        <p>Поражение.</p>
                    `;

                document.getElementById('optional-container').style.display = 'none';
                break;

            case 'goUp':
                storyDiv.innerHTML = `
                        <p>Ты поднялся на мостик.</p>
                        <p>Рассказать правду о себе или солгать?</p>
                        <button type="button" class="button" onclick="choose('tellTruth')">Рассказать правду о себе</button>
                        <button type="button" class="button" onclick="choose('lie')">Солгать о себе</button>
                    `;
                break;

            case 'refuse':
                storyDiv.innerHTML = `
                        <p>Ты не пошёл на переговоры.</p>
                        <p>Поражение.</p>
                    `;
                document.getElementById('optional-container').style.display = 'none';
                break;

            case 'tellTruth':
                storyDiv.innerHTML = `
                        <p>Ты рассказал правду.</p>
                        <p>Капитан поверил и помог восстановить память.</p>
                        <p>Тебя вернули домой.</p>
                        <p><strong>Победа!</strong></p>
                    `;
                document.getElementById('optional-container').style.display = 'none';
                break;

            case 'lie':
                storyDiv.innerHTML = `
                        <p>Ты солгал.</p>
                        <p>Твою ложь разоблачили.</p>
                        <p>Поражение.</p>
                    `;
                document.getElementById('optional-container').style.display = 'none';
                break;
        }
    }

</script>
</body>
</html>