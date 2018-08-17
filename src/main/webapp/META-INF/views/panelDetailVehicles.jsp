<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Vehicles panel</h2>

<table id="table_template">
    <tr>
        <th>Info</th>
        <th>Detail</th>
    </tr>
    <tr>
        <td>Vehicle id</td>
        <td>${vehicle.id}</td>
    </tr>
    <tr>
        <td>Model</td>
        <td>${vehicle.model}</td>
    </tr>

    <tr>
        <td>Brand</td>
        <td>${vehicle.brand}</td>
    </tr>
    <tr>
        <td>Production year</td>
        <td>${vehicle.productionYear}</td>
    </tr>
    <tr>
        <td>Registration number</td>
        <td>${vehicle.registrationNumber}</td>
    </tr>
    <tr>
        <td>Technical review</td>
        <td>${vehicle.technicalReviewDate}</td>
    </tr>
    <tr>
        <td>Customer name</td>
        <td>${vehicle.customer.name} ${vehicle.customer.surname}</td>
    </tr>











    </tr>

</table>




<%@include file="default/footer.jsp"%>