<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Error </title>
</head>

<body>
Exception: ${error} <br/>
<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
    ${trace}<br/>
</c:forEach>
Message from exception: ${exceptionMessage}<br/>
<a href="${pageContext.request.contextPath}/reg">Back to registration</a>
</body>
</html>