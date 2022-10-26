<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <title>registration</title>
</head>
<body>

<form class="FillTheForm" action="reg" method="POST">
    <b><h6>Enter your name: </h6></b>
    <input type="text" name="username" placeholder="name" class="form-control">
    </br>
    <b><h6>Enter your phone: </h6></b>
    <input type="text" name="phone" placeholder="phone" value="(+375)" class="form-control">
    </br>
    <b><h6>Enter your email: </h6></b>
    <input type="text" name="email" placeholder="email" class="form-control">
    </br>
    <input type="submit" class="btn btn-danger" value="submit"/>
</form>
</body>
</html>
