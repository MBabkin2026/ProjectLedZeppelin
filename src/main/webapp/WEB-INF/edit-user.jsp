<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/edit-user">

    <input type="hidden" name="id" value="${user.id}">

    <fieldset>
        <legend>Edit user: ${user.login}</legend>


        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" class="form-control input-md"
                       value="${user.login}" required>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="password" type="text" class="form-control input-md"
                       value="${user.password}" required>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-4">
                <select id="role" name="role" class="form-control">
                    <c:forEach var="role" items="${applicationScope.roles}">
                        <option value="${role}" ${role == user.role ? 'selected' : ''}>${role}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-8">

                <button type="submit" name="update" value="true" class="btn btn-primary">Update</button>

                <button type="submit" name="delete" value="true"
                        onclick="return confirm('Вы уверены, что хотите удалить пользователя?')"
                        class="btn btn-danger">Delete</button>
            </div>
        </div>

    </fieldset>

    <div class="col-md-8">
        <a href="${pageContext.request.contextPath}/user-list"
           class="btn btn-info" role="button">Return to list users</a>
    </div>
</form>


<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>