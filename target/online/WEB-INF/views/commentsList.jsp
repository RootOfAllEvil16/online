<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Comments</h1>

            <p class="lead">Check comments from all users</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">


                <th>Episode</th>
                <th>Comment</th>
                <th>Date</th>
                <th>Username</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${comments}" var="comments">
                <tr>

                    <td><a href="<spring:url value="/series/episodeView/${comments.episode.episodeId}"/>">${comments.episode.episodeNum}
                        <span class="glyphicon glyphicon-eye-open"></span></a></td>
                    <td>${comments.comment}</td>
                    <td><fmt:formatDate value="${comments.commentDate}"/></td>
                    <td>${comments.user.userName}</td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
        <a href="<spring:url value="/" />" class="btn btn-primary">Back</a>


<%@include file="/WEB-INF/views/template/footer.jsp" %>