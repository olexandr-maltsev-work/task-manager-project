<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
`<jsp:include page="header.jsp"></jsp:include>

<html>
<head>
    <meta charset="UTF-8">
    <title>Task List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="resources/style.css">

    <script type="text/javascript">
        function doDelete(id) {
            if (confirm("This task well be deleted")) {
                window.location.href = "TaskDelete?taskId=" + id;
            }
        }
    </script>
</head>

<body>
<h2>Tasks</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td><a href="${pageContext.request.contextPath}/TaskEdit?taskId=${task.id}">edit</a>
                <a href="#" onclick="doDelete(${task.id})">delete</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <h2>Create new task:</h2>
    <form action="TaskCreate" method="post">
        <input type="text" name="description" value="${task.description}" placeholder="enter description"/>
        <input type="submit" value="Create task"/>
    </form>

</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>