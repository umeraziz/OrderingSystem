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
                        <h5>Product Sku List</h5>
                        <div class="ibox-tools">
                            <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addProductSkuModal">Add New Product Sku</button>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table m-t-lg">
                            <thead>
                            <tr>
                                <th class="col-xs-1">Id</th>
                                <th class="col-xs-4">Sku Code</th>
                                <th class="col-xs-4">Sku Price</th>
                                <th class="col-xs-3">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productSkuList}" var="productSkuList">
                                <tr>
                                    <td>${productSkuList.productSkuId}</td>
                                    <td>${productSkuList.productSkuCode}</td>
                                    <td>${productSkuList.productSkuPrice}</td>
                                    <td>
                                        <a class="btn btn-primary btn-xs" href="#" disabled>Apply Discount</a>
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

        <div id="addProductSkuModal" class="modal fade" role="dialog">
            <form:form action="${pageContext.request.contextPath}/productsku" method="post" modelAttribute="productSkuInfo">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Product Sku Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <select class="form-control" name="productId">
                                    <c:forEach items="${productList}" var="productListItem">
                                        <option value="${productListItem.productId}">${productListItem.productName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <form:label path="productSkuCode">Sku Code</form:label>
                                <form:input path="productSkuCode" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <form:label path="productSkuPrice">Sku Price</form:label>
                                <form:input path="productSkuPrice" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Add Product Sku</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
        <%--</form:form>--%>
    </jsp:body>
</t:wrapper>