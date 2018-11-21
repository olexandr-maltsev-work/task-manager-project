<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
        <meta charset="UTF-8">
        <title>Task List</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css">

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
                <td><a href="/TaskEdit?taskId=${task.id}">edit</a>
                    <a href="#" onclick="doDelete(${task.id})">delete</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>