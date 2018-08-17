<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Vehicles panel</h2>

<table id="table_template">
    <tr>
        <th>Vehicle id</th>
        <th>Model</th>
        <th>Brand</th>
        <th>Production year</th>
        <th>Registration number</th>
        <th>Technical review</th>
        <th>Customer name</th>
        <th>Repair history</th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.id}</td>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.productionYear}</td>
            <td>${vehicle.registrationNumber}</td>
            <td>${vehicle.technicalReviewDate}</td>
            <td>${vehicle.customer.name}</td>
            <td>
                <form action="/searchControllerOrders" method="post">
                    <button type="submit" name="vehicleId" value="${vehicle.id}" class="btn-link">History</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>



<%@include file="default/footer.jsp"%>