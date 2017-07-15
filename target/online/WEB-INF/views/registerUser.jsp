<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register User</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="user">

            <h3>Basic Info</h3>

            <div class="form-group">
                <label for="email">Email</label><span style="color: #ff0000;"> ${emailMsg} </span><form:errors
                    path="email" cssStyle="color: #ff0000;"/>
                <form:input path="email" id="email" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="userName">Username</label><span style="color: #ff0000;"> ${userNameMsg}
            </span><form:errors path="userName" cssStyle="color: #ff0000;"/>
                <form:input path="userName" id="userName" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="password">Password</label><form:errors
                    path="password" cssStyle="color: #ff0000;"/>
                <form:password path="password" id="password" class="form-Control"/>
            </div>
            <br>

            <br><br>
            <input type="Submit" value="Submit" class="btn btn-default">
            <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
