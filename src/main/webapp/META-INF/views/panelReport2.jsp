<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="default/header.jsp"%>

<h2>Report 2: </h2>
<c:set var="price1" value="${0}"/>
<c:set var="price2" value="${0}"/>
<c:set var="price3" value="${0}"/>
<c:set var="grandtotal" value="${0}"/>
<table id="table_template">
    <tr>
        <th>Client's price</th>
        <th>Parts's price</th>
        <th>Employee's price</th>
    </tr>

    <c:forEach items="${finances}" var="finance">
        <tr>
            <td>${finance.priceClients}</td>
            <td>${finance.priceParts}</td>
            <td>${finance.priceEmployee*finance.workingHour}</td>
            <c:set var="price1" value="${price1 + finance.priceClients}" />
            <c:set var="price2" value="${price2 + finance.priceParts}" />
            <c:set var="price3" value="${price3 + finance.priceEmployee*finance.workingHour}" />
        </tr>
    </c:forEach>
    <tr>
        <th>Total</th>
        <th>Total</th>
        <th>Total</th>
    </tr>
    <tr>
        <td>${price1}</td>
        <td>${price2}</td>
        <td>${price3}</td>
    </tr>
    <tr>
        <c:set var="grandtotal" value="${price1 - price2 - price3}" />

        <th colspan="3" style="text-align: center">Grand Total</th>
    </tr>
    <tr>
        <%--<td colspan="3" style="text-align: center"><fmt:formatNumber type="number" maxIntegerDigits="2" value="${grandtotal}" /></td>--%>
        <td colspan="3" style="text-align: center">${grandtotal}</td>
    </tr>
</table>




<%@include file="default/footer.jsp"%>