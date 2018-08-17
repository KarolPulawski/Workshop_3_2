<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Edit customer: id= ${id} </h2>

<form action="" method="POST">
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
    <input type="submit" value="Edit">
</form>

<%@include file="default/footer.jsp"%>