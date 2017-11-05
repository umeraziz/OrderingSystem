<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OPTP Work In Progress</title>
    <link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/inspinia/css/style.css"/>" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h1>WIP</h1>
    <h3 class="font-bold">Work In Progress</h3>
    <div class="error-desc">
        The page you are trying to access is under construction, Please try again later.<br/>
        You can go back to main page: <br/><a href="${pageContext.request.contextPath}/adminDashboard" class="btn btn-primary m-t">Dashboard</a>
    </div>
</div>
<!-- Mainly scripts -->
<script type="text/javascript" src="<c:url value="/assets/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/bootstrap/assets/javascripts/bootstrap.min.js"/>"></script>
</body>
</html>
