<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Episode</h1>

            <p class="lead">Fill the below information to add episode:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/series/addEpisode" method="post"
                   commandName="episode" enctype="multipart/form-data">
            <form:hidden path="episodeId" value="${episode.episodeId}"/>
            <div>
            <form:select path="season.seasonId" items="${seasonList}" itemValue="seasonId" itemLabel="seasonNum"
                         class="form-control">
                </div></form:select>

        <div class="form-group">
            <label for="episodeNum">Episode Number</label> <form:errors path="episodeNum" cssStyle="color: #ff0000;"/>
            <form:input path="episodeNum" id="episodeNum" class="form-Control"/>
        </div>

            <div class="form-group">
                <label class="control-label" for="episodeImage">Upload Episode Cover</label>
                <form:input id="episodeImage" path="episodeImage" type="file" class="form:input-large"/>
            </div>
            <div class="form-group">
                <label class="control-label" for="videoFile">Upload Episode Video</label>
                <form:input id="videoFile" path="videoFile" type="file" class="form:input-large"/>
            </div>


            <br><br>
            <input type="submit" value="Finish" name="/series/seriesList/all"/>
            <input type="submit" value="Back" name="/admin/series/addSeason"/>


        </form:form>
    </div>
</div>