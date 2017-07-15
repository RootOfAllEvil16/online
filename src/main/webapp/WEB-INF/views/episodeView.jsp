<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Episode</h1>

            <p class="lead">Enjoy</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${episode.episodeId}.png" /> " alt="image"
                         style="width:100%"/>
                </div>

                <p>
                    <a href="<spring:url value="/series/contentList/all" />" class="btn btn-default">Back</a>
                </p>
<p>
    <a href="<spring:url value="/user/series/episodeView/${episode.episodeId}/addComment" />" class="btn btn-default">Add Comment</a>
</p>


    <br><br>

                <div class="col-md-5">
                    <h3>${episode.season.show.showName}</h3>
                    <p>
                        <strong>Episode number</strong> : ${episode.episodeNum}
                    </p>
                    <p>
                        <video width="400" controls="controls">
                            <source src="<c:url value="/resources/video/${episode.episodeId}.mp4" />">
                        </video>
                    </p>

                    <br>

                    <c:forEach items="${episode.episodeComments}" var="episodeComment">
                        <p>${episodeComment.commentDate} ${episodeComment.user.userName}</p>
                        <p>${episodeComment.comment}</p>

                    </c:forEach>


                </div>
            </div>
        </div>
    </div>
</div>




