<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Pick season and episode to watch</h1>

            <p class="lead">Pick season and episode</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">

                <th>Show Name</th>
                <th>Season Number</th>
                <th>Episode Number</th>
                <th>Watch episode</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${episodes}" var="episodes">
                <tr>
                    <td>${episodes.season.show.showName}</td>
                    <td>${episodes.season.seasonNum}</td>
                    <td>${episodes.episodeNum}</td>
                    <td><a href="<spring:url value="/series/episodeView/${episodes.episodeId}"/>"
                    ><span class="glyphicon glyphicon-eye-open"></span></a></td>
                </tr>
            </c:forEach>


            </tbody>
        </table>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
