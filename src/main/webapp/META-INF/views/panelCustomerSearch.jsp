<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Customers panel</h2>

<table id="table_template">
    <tr>
        <th>Customer id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Birthday</th>
        <th>Vehicles</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthday}</td>
            <td>
                <form action="/searchControllerVehicles" method="post">
                    <button type="submit" name="customerId" value="${customer.id}" class="btn-link">Vehicles</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>



<%@include file="default/footer.jsp"%>