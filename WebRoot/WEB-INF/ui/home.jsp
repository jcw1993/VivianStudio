<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp" flush="true"/>

<body>
	<jsp:include page="navi.jsp" flush="true"/>
	<!-- Show
    ================================================== -->
    <section id="show">
        <div class="container">
            
            <div class="row">
                <div class="col-lg-12">
                    <div id="myCarousel" class="carousel slide">
                        <ol class="carousel-indicators">
                          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                          <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                          <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                        </ol>
                        <div class="carousel-inner">
                          <div class="item active">
                            <img src="http://caibaojian.com/bootstrap/assets/img/bootstrap-mdo-sfmoma-01.jpg" alt="">
                          </div>
                          <div class="item">
                            <img src="http://caibaojian.com/bootstrap/assets/img/bootstrap-mdo-sfmoma-02.jpg" alt="">
                          </div>
                          <div class="item">
                            <img src="http://caibaojian.com/bootstrap/assets/img/bootstrap-mdo-sfmoma-03.jpg" alt="">
                          </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                      </div>
                </div>
            </div>

        </div>

    </section>
   
   	<jsp:include page="feature.jsp" flush="true"/>
   	<jsp:include page="news.jsp" flush="true"/>
    <jsp:include page="footer.jsp" flush="true"/>

<script type="text/javascript">
    $('#myCarousel').carousel()
</script>

</body>

</html>