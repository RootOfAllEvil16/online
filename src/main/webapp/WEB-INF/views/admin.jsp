<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
            </h2>
        </c:if>

        <p>Here you can view, check and modify all content!</p>

        <h3>
            <a href="<c:url value="/admin/seriesListManagement" />">Series Management</a>
        </h3>

        <p>Here you can view, check and modify series!</p>

        <h3>
            <a href="<c:url value="/admin/user" />">User Management</a>
        </h3>

        <p>Here you can see user information!</p>

        <h3>
            <a href="<c:url value="/admin/commentsManagement" />">Comments Management</a>
        </h3>

        <p>Here you can manage all comments!</p>

    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
