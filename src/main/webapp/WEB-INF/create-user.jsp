<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Создание пользователя</h1>
<div class="container">
    <form class="form-horizontal" method="post">
        <fieldset>

            <!-- Form Name -->
            <%--        <legend>Form Name</legend>--%>
            <legend>Create user: ${requestScope.user.login}</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" value="${requestScope.user.login}" name="login" type="text"
                           placeholder="place for login" class="form-control input-md" required="">
<%--                    <span class="help-block">help</span>--%>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" value="${requestScope.user.password}" name="password" type="text"
                           placeholder="place for password" class="form-control input-md" required="">
<%--                    <span class="help-block">help</span>--%>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Role">Role</label>
                <div class="col-md-4">
                    <select id="role" name="role" class="form-control">
                        <c:forEach var="role" items="${applicationScope.roles}">
                            <option value="${role}" ${role==requestScope.user.role?"selected":""}>${role}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>

            <!-- Buttons  -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="create">Good Button</label>
                <div class="col-md-8">
                    <button id="create" name="create" class="btn btn-info">Create</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
