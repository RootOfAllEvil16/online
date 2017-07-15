<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image"
                 src="<c:url value="/resources/images/poi.jpg" />"
                 alt="First slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to Watch Series Online website</h1>

                    <p>Here you can watch best series and share your thoughts about it</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image"
                 src="<c:url value="/resources/images/westworld.jpg" />"
                 alt="Second slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>This is just portfolio demo website</h1>

                    <p>My first Java project</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image"
                 src="<c:url value="/resources/images/orphan_black.jpg" />"
                 alt="Third slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>I like good TV Series</h1>

                    <p>Hope you like interesting shows too! Enjoy/p>

                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<div class="container marketing">

    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/series/seriesList?searchCondition=Name" />"
               role="button">
                <img class="img-circle"
                     src="<c:url value="/resources/images/series.jpg" />"
                     alt="Generic placeholder image" width="140" height="140"></a>


            <h2>Show Names</h2>

            <p>Search you favorite show by name</p>

            <%--<p><a class="btn btn-default" href="<c:url value="/search/name" />" role="button">View details &raquo;</a></p>--%>

        </div>
    <!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/series/seriesList?searchCondition=Genre" />"
               role="button">
                <img class="img-circle"
                     src="<c:url value="/resources/images/series.jpg" />"
                     alt="Generic placeholder image" width="140" height="140"></a>

            <h2>Genres</h2>

            <p>What genre do you prefer?</p>



<%@include file="/WEB-INF/views/template/footer.jsp" %>

