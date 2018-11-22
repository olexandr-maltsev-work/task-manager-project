<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <H2>Registration page</H2>
    <form action="RegisterServlet" method="post">
        <input type="text" name="email" value="" placeholder="Please enter email">
        <input type="password" name="password" value="" placeholder="Please enter password">
        <input type="password" name="password" value="" placeholder="Repeat the password">
        <input type="text" name="Name" value="" placeholder="Please enter your name">
        <input type="submit" value="Save user"/>
    </form>
</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>
