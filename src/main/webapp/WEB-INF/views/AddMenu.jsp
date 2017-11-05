<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper supportBean="${supportBean}">
    <jsp:attribute name="stylesheet"/>
    <jsp:attribute  name="script"/>
    <jsp:body>
        <div class="row">
            <div class="col-md-6 col-lg-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Add / Edit Menu</h5>
                    </div>
                    <div class="ibox-content">
                        <c:if test="${success != null}">
                            <div class="alert alert-success">
                                <ul>
                                    <li>
                                        <c:if test="${success}">New Menu added successfully</c:if>
                                        <c:if test="${!success}">${menuInfo.menuTitle} already exists</c:if>
                                    </li>
                                </ul>
                            </div>
                        </c:if>
                        <form:form action="${pageContext.request.contextPath}/menu" method="post" modelAttribute="menuInfo">
                            <div class="form-group">
                                <form:label path="menuTitle">Menu Title</form:label>
                                <form:input path="menuTitle" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="menuSequenceNo">Menu Sequence No</form:label>
                                <form:input path="menuSequenceNo" cssClass="form-control"/>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Menu List</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <td class="col-xs-6">Menu Title</td>
                                    <td class="col-xs-2">Sequence</td>
                                    <td class="col-xs-4">Actions</td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${menuList}" var="menuElement">
                                    <tr>
                                        <td class="col-xs-6">${menuElement.menuTitle}</td>
                                        <td class="col-xs-2">${menuElement.menuSequenceNo}</td>
                                        <td class="col-xs-4">
                                            <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/menu/${menuElement.menuId}">Edit</a>
                                            <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/menu/${menuElement.menuId}">${menuElement.menuStatus ? "Enable" : "Disable"}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </jsp:body>
</t:wrapper>