<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-- Table CSS -->
<%--<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">--%>

<script>
    $(document).ready(function () {
        $('.table').DataTable({
            "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]]
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Series List Management Page</h1>

            <p class="lead">This is series list management page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Show Cover</th>
                <th>Show Name</th>
                <th>Genre</th>
                <th>To Main Series List</th>
                <th>Actions</th>
            </tr>
            </thead>
            <c:forEach items="${shows}" var="shows">

            <tr>
                <td><img src="<c:url value="/resources/images/${shows.showId}.png" /> " alt="image"
                         style="width:100%"/></td>
                <td>${shows.showName}</td>
                <td>${shows.genre}</td>
                <td><a href="<spring:url value="/series/seriesList/all" />"
                ><span class="glyphicon glyphicon-eye-open"></span></a></td>
                <td><a href="<spring:url value="/admin/series/deleteShow/${shows.showId}" />"
                    ><span class="glyphicon glyphicon-remove"></span></a></td>


                </c:forEach>
            </tr>


        </table>


        <a href="<spring:url value="/admin/series/addShow" />" class="btn btn-primary">Add Or Edit Series</a>
        <a href="<spring:url value="/admin" />" class="btn btn-primary">Back</a>



        <%@include file="/WEB-INF/views/template/footer.jsp" %>
