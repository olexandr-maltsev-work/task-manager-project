<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<div style="float: right; padding: 10px; text-align: right;">
    Hello, <%= session.getAttribute("userName") %>! &nbsp &nbsp &nbsp <a href="/LogOutServlet">LogOut</a>
</div>

</body>
</html>
