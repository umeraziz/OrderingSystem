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
                        <h5>Add / Edit City</h5>
                    </div>
                    <div class="ibox-content">
                        <c:if test="${success != null}">
                            <div class="alert alert-success">
                                <ul>
                                    <li>
                                        <c:if test="${success}">New city added successfully</c:if>
                                        <c:if test="${!success}">${cityInfo.cityName} already exists</c:if>
                                    </li>
                                </ul>
                            </div>
                        </c:if>
                        <form:form action="${pageContext.request.contextPath}/city" method="post" modelAttribute="cityInfo">
                            <div class="form-group">
                                <form:label path="cityName">City Name</form:label>
                                <form:input path="cityName" cssClass="form-control"/>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>City List</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <td class="col-xs-8">City Name</td>
                                    <td class="col-xs-4">Actions</td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cityList}" var="cityElement">
                                    <tr>
                                        <td class="col-xs-8">${cityElement.cityName}</td>
                                        <td class="col-xs-4">
                                            <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/city/${cityElement.cityId}" disabled>Edit</a>
                                            <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/city/${cityElement.cityId}" disabled>${cityElement.cityStatus ? "Enable" : "Disable"}</a>
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