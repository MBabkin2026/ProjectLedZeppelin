<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@include file="head.jsp"%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Список пользователей</title>--%>
<%--</head>--%>
<%--<body>--%>
<br>
<h1>Список пользователей</h1>
<br/>
<ul>
    <c:forEach var="user" items="${requestScope.users}">
        <li><a href="edit-user?id=${user.id}">${user.login}</a></li>
    </c:forEach>

<%--    <form action="${pageContext.request.contextPath}/create-user" method="post"--%>
<%--          class="col-md-8" style="margin:0; padding:0;">--%>
<%--        <button id="create" name="create" class="btn btn-info" type="submit">Create</button>--%>
<%--    </form>--%>

<%--    <div class="form-group">--%>
<%--        <label class="col-md-4 control-label" for="create">Зарегистрировать нового пользователя</label>--%>
<%--        <div class="col-md-8">--%>
<%--            <button id="create" name="create" class="btn btn-info">Create</button>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="col-md-8">
        <a href="${pageContext.request.contextPath}/create-user"
           class="btn btn-info" id="create" role="button">Create new user</a>
    </div>

</ul>



</body>
<%--</html>--%>
