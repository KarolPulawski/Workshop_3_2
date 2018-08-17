<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Report 1: </h2>

<table id="table_template">
    <tr>
        <th>Responsible employee</th>
        <th>Employee id</th>
        <th>Working hours</th>
    </tr>
    <c:forEach items="${finalList}" var="position">
        <tr>
            <td>${position.name} ${position.surname}</td>
            <td>${position.id}</td>
            <td>${position.workingHour}</td>
        </tr>
    </c:forEach>
</table>


<%@include file="default/footer.jsp"%>