<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User management/Browse</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/browse>" method="post">
    <table id="UserTable" border=1>
        <tr>
            <th></th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
        </tr>
        <c:forEach var="user" items="${sessionScope.users}">
            <tr>
                <td>
                    <input type="radio" name="id" id="id" value="">
                </td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.dateOfBirth}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" name="Add" value="Add">
    <input type="submit" name="Edit" value="Edit">
    <input type="submit" name="Delete" value="Delete">
    <input type="submit" name="Details" value="Details">
</form>
</body>
</html>