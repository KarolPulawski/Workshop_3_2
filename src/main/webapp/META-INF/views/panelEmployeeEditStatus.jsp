<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

<h2>Please select proper status:</h2>

    <form method="POST" action="">
        <label>
            <select name = "status">
                <option  value="IN_REPAIR">IN_REPAIR</option>
                <option  value="COST_ACCEPTED">COST_ACCEPTED</option>
                <option  value="RESIGNATION">RESIGNATION</option>
                <option  value="CONFIRMED">CONFIRMED</option>
                <option  value="READY_TO_GO">READY_TO_GO</option>
            </select>
        </label>

        <button type="submit" class="btn-link">Select status</button>
    </form>

<%@include file="default/footer.jsp"%>