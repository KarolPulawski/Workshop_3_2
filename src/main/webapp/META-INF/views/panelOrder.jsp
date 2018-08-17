<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Orders: </h2>

<table id="table_template">
    <tr>
        <th>Order id</th>
        <th>Receive order date</th>
        <th>Responsible</th>
        <th>Vehicle</th>
        <th>Status</th>
        <th colspan="2" style="text-align: center">Change status</th>
        <th>Details</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.receiveDate}</td>
            <td>${order.employee.name}</td>
            <td>${order.vehicle.model}</td>
            <td>${order.status}</td>
            <td>
                <form method="get" action="/panelOrderEditStatus">
                    <button type="submit" name="orderId" value=${order.id} class="btn-link">Change status</button>
                </form>
            </td>
            <td>
                <%--<form action="/panelOrderEditStatus" method="post">--%>
                    <%--<button type="submit" name="orderId" value="${order.id}" class="btn-link">Change status</button>--%>
                <%--</form>--%>
            </td>
            <td>
                <form action="/displayDetails" method="post">
                    <button type="submit" name="orderId" value="${order.id}" class="btn-link">Details</button>
                </form>
            </td>
            <td>
                <form action="/panelOrderEdit" method="get">
                    <button type="submit" name="orderId" value="${order.id}" class="btn-link">Edit</button>
                </form>
            </td>
            <td>
                <form action="/panelOrderDelete" method="post">
                    <button type="submit" name="orderId" value="${order.id}" class="btn-link">Delete</button>
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

<h4>Add new order:</h4>

<form action="/panelOrderAdd" method="POST">
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

    <input type="submit" value="Add">
</form>


<%@include file="default/footer.jsp"%>