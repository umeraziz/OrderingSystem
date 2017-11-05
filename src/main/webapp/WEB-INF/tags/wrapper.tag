<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="html master layout tag" pageEncoding="UTF-8" %>
<%@ attribute name="stylesheet" fragment="true" %>
<%@ attribute name="script" fragment="true" %>
<%@ attribute name="supportBean" required="true" type="com.optp.controllers.beans.SupportBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>OPTP Admin</title>
    <link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/animate.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/inspinia/css/style.css"/>" rel="stylesheet">
    <jsp:invoke fragment="stylesheet"/>
</head>
<%--<body class="md-skin no-skin-config">--%>
<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear">
                                <span class="block m-t-xs">
                                    <strong class="font-bold">Administrator</strong>
                                </span>
                                <span class="text-muted text-xs block">System Administrator<b class="caret"></b></span>
                            </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="#">Profile</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">OPTP</div>
                </li>
                <li class="${supportBean.primaryActive == "dashboard" ? "active" : ""}">
                    <a href="#">
                        <i class="fa fa-book"></i>
                        <span class="nav-label">Dashboard</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level collapse">
                        <li class="${supportBean.secondaryActive == "adminDashboard" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/adminDashboard">Admin Dashboard</a>
                        </li>
                    </ul>
                </li>
                <li class="${supportBean.primaryActive == "definitionManagement" ? "active" : ""}">
                    <a href="#">
                        <i class="fa fa-book"></i>
                        <span class="nav-label">Master Definitions</span>
                        <span class="fa arrow"></span>
                    </a>

                    <ul class="nav nav-second-level collapse">
                        <li class="${supportBean.secondaryActive == "cityManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/city">Add / Edit City</a>
                        </li>
                        <li class="${supportBean.secondaryActive == "areaManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/area">Add / Edit Area</a>
                        </li>
                        <li class="${supportBean.secondaryActive == "blockManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/block">Add / Edit Block</a>
                        </li>
                        <li class="${supportBean.secondaryActive == "userManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/user">Add / Edit User</a>
                        </li>
                        <li class="${supportBean.secondaryActive == "menuManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/menu">Add / Edit Menu</a>
                        </li>
                        <li class="${supportBean.secondaryActive == "productManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/product">Add / Edit Product</a>
                        </li>
                        <li class="${supportBean.secondaryActive == "productSkuManagement" ? "active" : ""}">
                            <a href="${pageContext.request.contextPath}/productsku">Add / Edit Product Sku</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/address">Product Images</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/address">Product / Menu Mapping</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary" href="#"><i class="fa fa-bars"></i> </a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li> <span class="m-r-sm text-muted welcome-message"><strong>Welcome to <b style="color:#e0000a;">OPTP</b> Admin Panel</strong></span> </li>
                    <li> <a href="${pageContext.request.contextPath}/"> <i class="fa fa-sign-out"></i> Log out </a> </li>
                </ul>
            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <jsp:doBody/>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/assets/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/bootstrap/assets/javascripts/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/js/metisMenu/jquery.metisMenu.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/inspinia/js/inspinia.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/js/pace/pace.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/assets/js/slimscroll/jquery.slimscroll.min.js"/>"></script>
<jsp:invoke fragment="script"/>
</body>
</html>