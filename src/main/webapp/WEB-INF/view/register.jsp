<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration Task Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>

<c:if test="${not empty userdto.message}">
    <div>
        <label>
                ${userdto.message}
        </label>
    </div>
</c:if>

<h2>Register</h2>
<div class="form-style-2">
    <form action="UserRegistrationServlet" method="post">
        <p>Please fill in this form to create an account.</p>

        <b>Email:</b><br>
        <input type="text" name="email" value="${userdto.email}" placeholder="Enter Email" required>
        <br>
        <b>Password:</b><br>
        <input type="password" name="password" value="${userdto.password}" placeholder="Enter password" required>
        <br>
        <b>Repeat Password:</b><br>
        <input type="password" name="confirmPassword" value="${userdto.confirmPassword}" placeholder="Repeat password"
               required>
        <br>
        <b>Name:</b><br>
        <input type="text" name="userName" value="${userdto.name}" placeholder="Enter Your name" required>
        <br>
        <button type="submit" class="registerbtn">Register</button>
        <br>

    </form>

</div>
</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>
