<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-- Table CSS -->
<link href="<c:url value="/WEB-INF/resources/css/table.css" />" rel="stylesheet">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Comment Management Page</h1>

            <p class="lead">This is comment management page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Comment</th>
                <th>Comment date</th>
                <th>Username</th>
                <th>Episode Number</th>
                <th>Season Number</th>
                <th>Show Name</th>
                <th>Delete Comment</th>
            </tr>
            </thead>
            <c:forEach items="${commentList}" var="comments">
                <tr>
                    <td>${comments.comment}</td>
                    <td><fmt:formatDate value="${comments.commentDate}"/></td>
                    <td>${comments.user.userName}</td>
                    <td>${comments.episode.episodeNum}</td>
                    <td>${comments.episode.season.seasonNum}</td>
                    <td>${comments.episode.season.show.showName}</td>
                    <td><a href="<spring:url value="/admin/deleteComment/${comments.commentId}" />"
                    ><span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="<spring:url value="/admin" />" class="btn btn-primary">Back</a>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>