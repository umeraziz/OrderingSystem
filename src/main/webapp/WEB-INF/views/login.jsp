<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>INSPINIA | Login</title>
    <link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/inspinia/css/style.css"/>" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">OPTP</h1>
        </div>
        <h3>Welcome</h3>
        <%--<p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.</p>--%>
        <p>Login in.</p>
        <form class="m-t" role="form" action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Username" required="" name="userName">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" required="" name="logPassword">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
            <a href="#">
                <small>Forgot password?</small>
            </a>
            <p class="text-muted text-center">
                <small>Do not have an account?</small>
            </p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
        </form>
    </div>
</div>
<!-- Mainly scripts -->
<script src="<c:url value="/assets/jquery-3.1.1.min.js"/>"></script>
<script src="<c:url value="/assets/bootstrap/assets/javascripts/bootstrap.min.js"/>"></script>
</body>
</html>