<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
<h2>Register</h2>
<form action="UserRegistrationServlet" method="post">
    <p>Please fill in this form to create an account.</p>

    <b>Email:</b><br>
    <input type="text" name="email" placeholder="Enter Email" required>
    <br>
    <b>Password:</b><br>
    <input type="password" name="password" placeholder="Enter password" required>
    <br>
    <b>Repeat Password:</b><br>
    <input type="password" name="confirmPassword" placeholder="Repeat password" required>
    <br>
    Name:<br>
    <input type="text" name="userName" placeholder="Enter Your name">
    <br>
    <button type="submit" class="registerbtn">Register</button>
    <br>

</form>
</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>
