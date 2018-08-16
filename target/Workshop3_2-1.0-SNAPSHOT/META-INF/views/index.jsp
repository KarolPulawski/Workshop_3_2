<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>LATEST REPAIRS</h2>

<table id="table_template">
    <tr>
        <th>Order id</th>
        <th>Receive order date</th>
        <th>Start order date</th>
        <th>Responsible</th>
        <th>Vehicle</th>
        <th>Problem description</th>
        <th>Details</th>
    </tr>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.receiveDate}</td>
            <td>${order.startDate}</td>
            <td>${order.employee.name}</td>
            <td>${order.vehicle.model}</td>
            <td>${order.descriptionProblem}</td>


            <td>
                <form action="/displayDetails" method="post">
                    <button type="submit" name="orderId" value="${order.id}" class="btn-link">Details</button>
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


<%@include file="default/footer.jsp"%>