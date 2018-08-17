<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Edit employee: id= ${id} </h2>

<form action="" method="POST">
    <label>
        Receive date:
        <input type="text" name="orderReceiveDate">
    </label></br>
    <label>
        Start date:
        <input type="text" name="orderStartDate">
    </label></br>
    <label>
        Employee id:
        <input type="text" name="orderEmployeeId">
    </label></br>
    <label>
        Problem description:
        <input type="text" name="orderDescriptionProblem">
    </label></br>
    <label>
        Repair description:
        <input type="text" name="orderDescriptionRepair">
    </label></br>
    <label>
        Status:
        <input type="text" name="orderStatus">
    </label></br>
    <label>
        Vehicle id:
        <input type="text" name="orderVehicleId">
    </label></br>
    <label>
        Client price:
        <input type="text" name="orderPriceClient">
    </label></br>
    <label>
        Parts price:
        <input type="text" name="orderPriceParts">
    </label></br>
    <label>
        Employee price:
        <input type="text" name="orderPriceEmployee">
    </label></br>
    <label>
        Work hours:
        <input type="text" name="orderNumberHour">
    </label></br>

    <input type="submit" value="Edit">
</form>

<%@include file="default/footer.jsp"%>