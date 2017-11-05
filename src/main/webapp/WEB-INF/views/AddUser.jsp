<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper supportBean="${supportBean}">
    <jsp:attribute name="stylesheet"/>
    <jsp:attribute name="script"/>
    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>User List</h5>
                        <div class="ibox-tools">
                            <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addUserModal">Add New User</button>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table m-t-lg">
                            <thead>
                            <tr>
                                <th class="col-xs-1">Id</th>
                                <th class="col-xs-2">User Name</th>
                                <th class="col-xs-2">Email</th>
                                <th class="col-xs-2">Password</th>
                                <th class="col-xs-5">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${userList}" var="userItem">
                                <tr>
                                    <td>${userItem.userId}</td>
                                    <td>${userItem.userName}</td>
                                    <td>${userItem.password}</td>
                                    <td>${userItem.email}</td>
                                    <td>
                                        <a class="btn btn-primary btn-xs" href="#" disabled>Address List</a>
                                        <a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addUserAddressModal" href="#">Add New Address</a>
                                        <a class="btn btn-primary btn-xs" href="#" disabled>Contact List</a>
                                        <a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addUserContactModal" href="#">Add New Contact</a>
                                        <a class="btn btn-primary btn-xs" href="#" disabled>Enable / Disable</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <div id="addUserModal" class="modal fade" role="dialog">
            <form:form action="${pageContext.request.contextPath}/user" method="post" modelAttribute="userInfo">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">User Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <form:label path="userName">User Name</form:label>
                                <form:input path="userName" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="email">Email Address / User Id</form:label>
                                <form:input path="email" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="password">Password</form:label>
                                <form:input path="password" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Add User</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
        <div id="addUserAddressModal" class="modal fade" role="dialog">
            <form:form action="${pageContext.request.contextPath}/address" method="post">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">User Address Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <select class="form-control" name="cityId">
                                    <option value="" selected disabled>Select City</option>
                                    <c:forEach items="${cityList}" var="cityListItem">
                                        <option value="${cityListItem.cityId}">${cityListItem.cityName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="addressId">
                                    <option value="" selected disabled>Select Area</option>
                                    <c:forEach items="${areaList}" var="areaListItem">
                                        <option value="${areaListItem.areaId}">${areaListItem.areaName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="blockId">
                                    <option value="" selected disabled>Select Block</option>
                                    <c:forEach items="${blockList}" var="blockListItem">
                                        <option value="${blockListItem.blockId}">${blockListItem.blockName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input class="form-control" type="text">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" disabled>Add User Address</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
        <div id="addUserContactModal" class="modal fade" role="dialog">
            <form:form action="${pageContext.request.contextPath}/contact" method="post">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">User Contact Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Contact No</label>
                                <input class="form-control" type="text">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" disabled>Add User Contact</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </jsp:body>
</t:wrapper>