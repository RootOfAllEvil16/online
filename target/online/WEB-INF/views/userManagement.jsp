<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-- Table CSS -->
<link href="<c:url value="/WEB-INF/resources/css/table.css" />" rel="stylesheet">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User Management Page</h1>

            <p class="lead">This is the user management page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Email</th>
                <th>Username</th>
                <th>Password</th>

            </tr>
            </thead>
            <c:forEach items="${userList}" var="users">
                <tr>
                    <td>${users.email}</td>
                    <td>${users.userName}</td>
                    <td>${users.password}</td>


                </tr>
            </c:forEach>
        </table>
        <a href="<spring:url value="/admin" />" class="btn btn-primary">Back</a>

<%@include file="/WEB-INF/views/template/footer.jsp" %>