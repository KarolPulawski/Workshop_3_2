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
        <th>Orders</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthday}</td>
            <td>
                <form action="/panelCustomerVehicles" method="post">
                    <button type="submit" name="customerId" value="${customer.id}" class="btn-link">Vehicles</button>
                </form>
            </td>
            <td>
                <form action="/panelCustomerOrders" method="post">
                    <button type="submit" name="customerId" value="${customer.id}" class="btn-link">Orders</button>
                </form>
            </td>
            <td>
                <form action="/panelCustomerEdit" method="get">
                    <button type="submit" name="customerId" value="${customer.id}" class="btn-link">Edit</button>
                </form>
            </td>
            <td>
                <form action="/panelCustomerDelete" method="post">
                    <button type="submit" name="customerId" value="${customer.id}" class="btn-link">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h4>Add new customer:</h4>

<form action="/panelCustomerAdd" method="POST">
    <label>
        New customer name:
        <input type="text" name="customerName">
    </label></br>
    <label>
        New customer surname:
        <input type="text" name="customerSurname">
    </label></br>
    <label>
        New customer birthday:
        <input type="text" name="customerBirthday">
    </label></br>
    <input type="submit" value="Add">
</form>


<%@include file="default/footer.jsp"%>