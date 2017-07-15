<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Show</h1>

            <p class="lead">Fill the below information to add show:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/series/addShow" method="post"
                   commandName="show" enctype="multipart/form-data">
            <form:hidden path="showId" value="${show.showId}"/>


            <div class="form-group">
                <label class="control-label" for="showImage">Upload Show Cover</label>
                <form:input id="showImage" path="showImage" type="file" class="form:input-large"/>
            </div>
            <div class="form-group">
                <label for="name">Show Name</label> <form:errors path="showName" cssStyle="color: #ff0000;"/>
                <form:input path="showName" id="name" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="genre">Genre</label>
                <label class="checkbox-inline"><form:radiobutton path="genre" id="genre"
                                                                 value="SCIFI"/>SCIFI</label>
                <label class="checkbox-inline"><form:radiobutton path="genre" id="genre"
                                                                 value="WESTERN"/>WESTERN</label>
                <label class="checkbox-inline"><form:radiobutton path="genre" id="genre"
                                                                 value="DRAMA"/>DRAMA</label>
                <label class="checkbox-inline"><form:radiobutton path="genre" id="genre"
                                                                 value="COMEDY"/>COMEDY</label>
            </div>

            <br><br>
            <input type="submit" value="Next" name="/admin/series/addSeason"/>
            <input type="submit" value="Cancel" name="/admin/seriesListManagement"/>



        </form:form>
    </div>
</div>