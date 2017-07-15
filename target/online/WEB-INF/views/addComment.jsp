<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Comment</h1>

            <p class="lead">Share your opinion:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/user/series/episodeView/${comment.episode.episodeId}/addComment"
                   method="post"
                   commandName="comment" enctype="multipart/form-data">
            <form:hidden path="episode.episodeId" value="${comment.episode.episodeId}"/>



            <div class="form-group">
                <label for="comment">Comment</label> <form:errors path="comment" cssStyle="color: #ff0000;"/>
                <form:input path="comment" id="comment" class="form-Control"/>
            </div>


            <br><br>
            <input type="submit" value="Submit"  name="/commentsList/all"/>


        </form:form>
    </div>
</div>