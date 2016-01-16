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
                	<!-- <div id="owl-demo" class="owl-carousel owl-theme">
					  <div class="item active" class="carousel slide" onclick="location.href='schedule'" style="cursor: pointer;">
                            <img src="http://7xpxna.com1.z0.glb.clouddn.com/vscarouselOne.jpg" alt="">
                          </div>
                          <div class="item">
                            <img src="http://7xpxna.com1.z0.glb.clouddn.com/vscarouselTwo.jpg" alt="">
                          </div>
                          <div class="item">
                            <img src="http://7xpxna.com1.z0.glb.clouddn.com/vscarouselThree.png" alt="">
                          </div>
					</div> -->
                
                    <div id="myCarousel" >
                        <ol class="carousel-indicators">
                          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                          <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                          <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                        </ol>
                        <div class="carousel-inner">
                          <div class="item active" class="carousel slide" onclick="location.href='schedule'" style="cursor: pointer;">
                            <img src="http://7xpxna.com1.z0.glb.clouddn.com/vscarouselOne.jpg" alt="">
                          </div>
                          <div class="item">
                            <img src="http://7xpxna.com1.z0.glb.clouddn.com/vscarouselTwo.jpg" alt="">
                          </div>
                          <div class="item">
                            <img src="http://7xpxna.com1.z0.glb.clouddn.com/vscarouselThree.png" alt="">
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
     
     
/* 	$("#myCarousel").swiperight(function() {  
	  $(this).carousel('prev');  
		});  
 	$("#myCarousel").swipeleft(function() {  
    $(this).carousel('next');  
});  */
 
  $("#owl-demo").owlCarousel({
	 
     navigation : true, // Show next and prev buttons
     slideSpeed : 300,
     paginationSpeed : 400,
     singleItem:true

     // "singleItem:true" is a shortcut for:
     // items : 1, 
     // itemsDesktop : false,
     // itemsDesktopSmall : false,
     // itemsTablet: false,
     // itemsMobile : false

 });
  
 </script>

</body>

</html>