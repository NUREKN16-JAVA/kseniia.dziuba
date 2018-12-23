<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>User management/Add</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/add" method="post">
    First Name: <input type="text" name="firstName" value=""><br/>
    Last Name: <input type="text" name="lastName" value=""><br/>
    Date of Birth: <input name="dateOfBirth"
                          value="<fmt:formatDate value="" type="date" dateStyle="medium"/>"><br>
    <input type="submit" name="okButton" value="Ok">
    <input type="submit" name="cancelButton" value="Cancel">
</form>
<c:if test="${requestScope.error != null}">
    <script>
        alert('${requestScope.error}')
    </script>
</c:if>
</body>
</html>