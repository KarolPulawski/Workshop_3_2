<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Please type date's range </h2>

<form action="" method="POST">
    <label>
        Date from:
        <input type="text" name="dateFrom">
    </label></br>
    <label>
        Date to:
        <input type="text" name="dateTo">
    </label></br>

    <input type="submit" value="Launch">
</form>

<%@include file="default/footer.jsp"%>