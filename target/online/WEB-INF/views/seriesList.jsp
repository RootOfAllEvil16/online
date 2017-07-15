<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-- Table CSS -->
<%--<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">--%>

<script>
    $(document).ready(function () {
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[3, 5, 10, 25, 50, -1], [3, 5, 10, 25, 50, "All"]],
            "oSearch": {"sSearch": searchCondition}
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Series</h1>

            <p class="lead">Checkout all series available now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Show Image</th>
                <th>Show Name</th>
                <th>Genre</th>
                <th>To Seasons Content</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${shows}" var="shows">

                <tr>
                    <td><img src="<c:url value="/resources/images/${shows.showId}.png" /> " alt="image"
                             style="width:100%"/></td>
                    <td>${shows.showName}</td>
                    <td>${shows.genre}</td>
                    <td><a href="<spring:url value="/series/contentList/all"/>"
                    ><span class="glyphicon glyphicon-eye-open"></span></a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

<%@include file="/WEB-INF/views/template/footer.jsp" %>

