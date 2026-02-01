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


            <legend>${requestScope.user != null ? 'Edit user: ' + requestScope.user.login : 'Create user'}</legend>

            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" value="${requestScope.user.login}" name="login" type="text"
                           placeholder="place for login" class="form-control input-md" required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" value="${requestScope.user.password}" name="password" type="password"
                           placeholder="place for password" class="form-control input-md" required="">
                </div>
            </div>


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


            <div class="form-group">
                <label class="col-md-4 control-label" for="create">Create user</label>
                <div class="col-md-8">
                    <button id="create" name="create" class="btn btn-info">Create</button>
                </div>

                <label class="col-md-4 control-label" for="">Return</label>
                <div class="col-md-8">
                    <button id="create" name="return" class="btn btn-info">Return</button>
                </div>
            </div>


        </fieldset>
    </form>
</div>
</body>
</html>
