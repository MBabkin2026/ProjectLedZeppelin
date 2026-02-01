<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>

<br>
<h1>Список пользователей</h1>
<br/>
<ul>
    <


    <%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@include file="head.jsp"%>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Логин</th>
            <th>Роль</th>
            <th>Игр сыграно</th>
            <%--            <th>Победы</th>          <!-- Новая колонка -->--%>
            <%--            <th>Поражения</th>      <!-- Новая колонка -->--%>
            <th>Последняя игра</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.role}</td>
                <!-- Количество игр -->
                <td>${user.gameHistory.size()}</td>
                <!-- Победы -->
                    <%--                <td>${user.wins}</td> --%>
                <!-- Поражения -->
                    <%--                <td>${user.losses}</td> --%>
                <!-- Последняя игра -->
                <td>
                    <c:choose>
                        <c:when test="${not empty user.gameHistory}">
                            <fmt:formatDate
                                    value="${user.gameHistory[0].timestamp}"
                                    pattern="dd.MM.yyyy HH:mm" />
                        </c:when>
                        <c:otherwise>Нет игр</c:otherwise>
                    </c:choose>
                </td>
                <!-- Действия -->
                <td>
                    <a href="${pageContext.request.contextPath}/edit-user?id=${user.id}"
                       class="btn btn-sm btn-outline-primary">Редактировать</a>
                    <a href="${pageContext.request.contextPath}/quest-list?userId=${user.id}"
                       class="btn btn-sm btn-outline-info">Выбрать квест</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Создать пользователя -->
    <ul>
        <div class="col-md-8">
            <a href="${pageContext.request.contextPath}/create-user"
               class="btn btn-info" id="create" role="button">Create new user</a>
        </div>
    </ul>