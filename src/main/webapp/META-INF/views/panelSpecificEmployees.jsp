<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Employee: </h2>

<table id="table_template">
    <tr>
        <th>Employee id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Phone number</th>
        <th>Note</th>
        <th>Salary (per hour)</th>
        <th>Orders</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.address}</td>
            <td>${employee.number}</td>
            <td>${employee.note}</td>
            <td>${employee.salaryPerHour}</td>


            <td>
                <form action="/panelEmployee" method="post">
                    <button type="submit" name="employeeId" value="${employee.id}" class="btn-link">Orders</button>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>


<%@include file="default/footer.jsp"%>