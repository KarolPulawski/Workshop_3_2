<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Edit customer: id= ${id} </h2>

<form action="" method="POST">
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
    <input type="submit" value="Edit">
</form>

<%@include file="default/footer.jsp"%>