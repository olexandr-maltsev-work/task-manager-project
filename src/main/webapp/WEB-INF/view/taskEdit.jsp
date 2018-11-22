<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Task: ${task.description}</h2>
<form action="TaskEdit" method="post">
    <input type="hidden" name="id" value="${task.id}"/>
    <input type="text" name="description" value="${task.description}" placeholder="enter description"/>
    <input type="submit" value="Save task"/>
</form>

</body>
</html>
