<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Employees panel</h2>

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
        <th>Edit</th>
        <th>Delete</th>
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
            <td>
                <form action="/panelEmployeeEdit" method="get">
                    <button type="submit" name="employeeId" value="${employee.id}" class="btn-link">Edit</button>
                </form>
            </td>
            <td>
                <form action="/panelEmployeeDelete" method="post">
                    <button type="submit" name="employeeId" value="${employee.id}" class="btn-link">Delete</button>
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

<h4>Add new employee:</h4>

<form action="/panelEmployeeAdd" method="POST">
    <label>
        New employee name:
        <input type="text" name="employeeName">
    </label></br>
    <label>
        New employee surname:
        <input type="text" name="employeeSurname">
    </label></br>
    <label>
        New employee address:
        <input type="text" name="employeeAddress">
    </label></br>
    <label>
        New employee number:
        <input type="text" name="employeeNumber">
    </label></br>
    <label>
        New employee note:
        <input type="text" name="employeeNote">
    </label></br>
    <label>
        New employee salary:
        <input type="text" name="employeeSalary">
    </label></br>
    <input type="submit">
</form>


<%@include file="default/footer.jsp"%>