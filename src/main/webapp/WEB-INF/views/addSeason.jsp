<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Season</h1>

            <p class="lead">Fill the below information to add season:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/series/addSeason" method="post"
                   commandName="season" enctype="multipart/form-data">
            <form:hidden path="seasonId" value="${season.seasonId}"/>
            <div>
            <form:select path="show.showId" items="${showList}" itemValue="showId" itemLabel="showName"
                         class="form-control">
                </div></form:select>
            <div class="form-group">
                <label for="seasonNum">SeasonNum</label> <form:errors path="seasonNum" cssStyle="color: #ff0000;"/>
                <form:input path="seasonNum" id="seasonNum" class="form-Control"/>
            </div>


            <br><br>
            <input type="submit" value="Next" name="/admin/series/addEpisode"/>
            <input type="submit" value="Cancel" name="/admin/series/addShow"/>



        </form:form>
    </div>
</div>