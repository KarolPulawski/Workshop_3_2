<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Order id:${order.id} details</h2>

<table id="table_template">
    <tr>
        <th>Info</th>
        <th>Detail</th>
    </tr>
    <tr>
        <td>Customer</td>
        <td>${order.vehicle.customer.name} ${order.vehicle.customer.surname}</td>
    </tr>
    <tr>
        <td>Customer birthday</td>
        <td>${order.vehicle.customer.birthday}</td>
    </tr>
    <tr>
        <td>Receive order date</td>
        <td>${order.receiveDate}</td>
    </tr>
    <tr>
        <td>Start working date</td>
        <td>${order.startDate}</td>
    </tr>
    <tr>
        <td>Responsible person</td>
        <td>${order.employee.name}</td>
    </tr>
    <tr>
        <td>Contact number</td>
        <td>${order.employee.number}</td>
    </tr>
    <tr>
        <td>Problem description</td>
        <td>${order.descriptionProblem}</td>
    </tr>
    <tr>
        <td>Repair description</td>
        <td>${order.descriptionRepair}</td>
    </tr>
    <tr>
        <td>Repair status</td>
        <td>${order.status}</td>
    </tr>
    <tr>
        <td>Vehicle brand and model</td>
        <td>${order.vehicle.brand} ${order.vehicle.model}</td>
    </tr>
    <tr>
        <td>Price for client</td>
        <td>${order.priceClient}</td>
    </tr>
    <tr>
        <td>Parts cost</td>
        <td>${order.priceParts}</td>
    </tr>
    <tr>
        <td>Employee cost</td>
        <td>${order.priceEmployee}</td>
    </tr>
    <tr>
        <td>Number of working hours</td>
        <td>${order.numberHour}</td>
    </tr>


    <%--<c:forEach items="${orderList}" var="order">--%>
        <%--<tr>--%>
            <%--<td>${order.id}</td>--%>
            <%--<td>${order.receiveDate}</td>--%>
            <%--<td>${order.startDate}</td>--%>
            <%--<td>${order.employee.name}</td>--%>
            <%--<td>${order.vehicle.model}</td>--%>
            <%--<td>${order.descriptionProblem}</td>--%>


            <%--<td>--%>
                <%--<form action="/displayDetails" method="get">--%>
                    <%--<button type="submit" name="orderId" value="${order.id}" class="btn-link">Edit</button>--%>
                <%--</form>--%>
            <%--</td>--%>
            <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<form action="/userDelete" method="post">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<button type="submit" name="userId" value="${user.id}" class="btn-link">Delete</button>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</form>&ndash;%&gt;--%>

            <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
</table>


<%@include file="default/footer.jsp"%>