<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>

<body>
<div class="flex-container">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="menu" />
    <article class="article">
        <tiles:insertAttribute name="body" />
    </article>
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>