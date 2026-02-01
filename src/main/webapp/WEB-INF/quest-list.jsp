<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<html>
<head>
    <title>Выбор квеста</title>
</head>
<body>
<div class="container mt-4">
    <h2>Выберите квест для пользователя #${userId}</h2>

    <c:if test="${empty quests}">
        <p class="text-muted">Квесты отсутствуют.</p>
    </c:if>

    <div class="row">
        <c:forEach items="${quests}" var="quest">
            <div class="col-md-6 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${quest.title}</h5>
                        <p class="card-text text-muted">${quest.description}</p>


                        <c:choose>
                            <c:when test="${quest.id == 1 || quest.title == 'UFO Quest'}">
                                <a href="${pageContext.request.contextPath}/ufo-quest?userId=${userId}"
                                   class="btn btn-primary btn-sm">
                                    Начать UFO Quest
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/quest?userId=${userId}&questId=${quest.id}"
                                   class="btn btn-primary btn-sm">
                                    Начать
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/user-list"
           class="btn btn-outline-secondary">
            ← Вернуться к списку пользователей
        </a>
    </div>
</div>
</body>
</html>