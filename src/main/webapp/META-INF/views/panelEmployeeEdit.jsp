<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Edit employee: id= ${id} </h2>

<form action="" method="POST">
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