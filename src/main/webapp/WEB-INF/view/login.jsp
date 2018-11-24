<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Task Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
</head>

<body>
<h2>Login</h2>
<form action="UserLoginServlet" method="post">
    <b>Email:</b><br>
    <input type="text" name="email" placeholder="Enter Email" required>
    <br>
    <b>Password:</b><br>
    <input type="password" name="password" placeholder="Enter password" required>
    <br>
    <button type="submit" class="registerbtn">Login</button>
    <br>
</form>
</body>
</html>
