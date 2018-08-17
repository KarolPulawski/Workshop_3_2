<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Vehicles panel</h2>

<table id="table_template">
    <tr>
        <th>Vehicle id</th>
        <th>Model</th>
        <th>Brand</th>
        <%--<th>Production year</th>--%>
        <%--<th>Registration number</th>--%>
        <%--<th>Technical review</th>--%>
        <%--<th>Customer name</th>--%>
        <th>Details</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.id}</td>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <%--<td>${vehicle.productionYear}</td>--%>
            <%--<td>${vehicle.registrationNumber}</td>--%>
            <%--<td>${vehicle.technicalReviewDate}</td>--%>
            <%--<td>${vehicle.customer.name}</td>--%>


            <td>
                <form action="/panelVehicle" method="post">
                    <button type="submit" name="vehicleId" value="${vehicle.id}" class="btn-link">Details</button>
                </form>
            </td>
            <td>
                <form action="/panelVehicleEdit" method="get">
                    <button type="submit" name="vehicleId" value="${vehicle.id}" class="btn-link">Edit</button>
                </form>
            </td>
            <td>
                <form action="/panelVehicleDelete" method="post">
                    <button type="submit" name="vehicleId" value="${vehicle.id}" class="btn-link">Delete</button>
                </form>
            </td>
                <%--<td>--%>
                <%--<form action="/userDelete" method="post">--%>
                <%--<button type="submit" name="userId" value="${user.id}" class="btn-link">Delete</button>--%>
                <%--</form>--%>

                <%--</td>--%>
        </tr>
    </c:forEach>
</table>

<h4>Add new vehicle:</h4>

<form action="/panelVehicleAdd" method="POST">
    <label>
        New vehicle model:
        <input type="text" name="vehicleModel">
    </label></br>
    <label>
        New vehicle brand:
        <input type="text" name="vehicleBrand">
    </label></br>
    <label>
        New vehicle productionYear:
        <input type="text" name="vehicleProductionYear">
    </label></br>
    <label>
        New vehicle registration number:
        <input type="text" name="vehicleRegistrationNumber">
    </label></br>
    <label>
        New vehicle technical date:
        <input type="text" name="vehicleTechnicalReviewDate">
    </label></br>
    <label>
        New Customer id:
        <input type="text" name="vehicleCustomerId">
    </label></br>
    <input type="submit" value="Add">
</form>


<%@include file="default/footer.jsp"%>