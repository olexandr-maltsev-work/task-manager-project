<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login Task Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
</head>

<body>

<c:if test="${not empty userdto.message}">
    <div id="errorMessage">
        <h3>
                ${userdto.message}
        </h3>
    </div>
</c:if>

<div class="form-style-2">
    <h2>Login</h2>
    <form action="UserLoginServlet" method="post">
        <b>Email:</b><br>
        <input type="text" name="email" value="${userdto.email}" placeholder="Enter Email" required>
        <br>
        <b>Password:</b><br>
        <input type="password" name="password" value="${userdto.password}" placeholder="Enter password" required>
        <br>
        <button type="submit">Login</button>
        <br>
    </form>
    <br>
    <a href="UserRegistrationServlet">Not registered yet?</a>

</div>
</body>
</html>
