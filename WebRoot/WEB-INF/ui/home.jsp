<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp" flush="true"/>

<body>
<header class="navbar-wrapper">
        <div class="navbar navbar-default navbar-static-top home-navbar" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> -->
                    <!--logo start-->
                    <div class="brand">
                        <a href="home" class="logo">
                            <i class="icon-layers"></i>
                            <span>Vivian</span>Studio</a>
                    </div>
                    <!--logo end-->
                    
                </div>
<!--                 <div class="navbar-collapse collapse">
 -->                    <ul class="nav navbar-nav pull-right" id="">
                        <li><a href="#home">首页</a>
                        </li>
                        <li><a href="schedule">课程安排</a>
                        </li>
                        <li><a href="#show">风采展示</a>
                        </li>
                        <li><a href="#contact">联系我们</a>
                        </li>
                        <li class="pull-right"><a href="#contact">登录</a>
                        </li>
                    </ul>
<!--                 </div>
 -->            </div>
        </div>
    </header>

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
    



     <!-- Features Section
    ================================================== -->
    <section id="features">
        <div class="container">
            <div class="">
                <div class="col-lg-12 text-center">
                    <header>
                        <p class="text-muted">何老师工作室 | Vivian Studio | 中学英语培优教育</p>
                        <div class="spacer"></div>
                    </header>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-3 text-center wow fadeInUp">
                    <div class="icon-wrapper">
                        <p class="icon-circle">
                            <i class="icon icon-screen-smartphone"></i>
                        </p>
                    </div>
                    <h4>最新课程</h4>
                </div>
                <div class="col-xs-3 text-center wow fadeInUp">
                    <div class="icon-wrapper">
                        <p class="icon-circle">
                            <i class="icon icon-graph"></i>
                        </p>
                    </div>
                    <h4>在线报名</h4>
                </div>
                <div class="col-xs-3 text-center wow fadeInUp">
                    <div class="icon-wrapper">
                        <p class="icon-circle">
                            <i class="icon fa fa-html5"></i>
                        </p>
                    </div>
                    <h4>学生寄语</h4>
                </div>
                <div class="col-xs-3 text-center wow fadeInUp">
                    <div class="icon-wrapper">
                        <p class="icon-circle">
                            <i class="icon fa fa-google"></i>
                        </p>
                    </div>
                    <h4>学员登录</h4>
                </div>
            </div>
            
            
        </div>
    </section>


  <!-- News Section
    ================================================== -->
 <section id="news">
        <div class="container">
			<div class="row">
            	<div class="col-md-12 wow vs-news">
            		<div class="panel panel-primary">
            			<div class="panel-heading">
                             <h3 class="panel-title">今日头条</h3>
                             
                         </div>
                         <div class="panel-body profile-wrapper">
                            <div class="vs-news-content">
	                             <div class="col-xs-3">
	                                    <div class="profile-pic text-center">
	                                        <img src="assets/img/team-3.jpg" alt="" class="img-circle">
	                                    </div>
	                             </div>
	                             <div class="col-xs-9">
	                                    <div class="profile-info">
	                                        <h3>2016 最新课程表</h3>
	                                    </div>
	                                    <p>
	                                  		Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo.
	                                    </p>
	                                    <div class="spacer"></div>
	                              </div>
	                              
                              </div>
                              
                              
                              <div class="vs-news-content">
	                             <div class="col-xs-3">
	                                    <div class="profile-pic text-center">
	                                        <img src="assets/img/team-2.jpg" alt="" class="img-circle">
	                                    </div>
	                             </div>
	                             <div class="col-xs-9">
	                                    <div class="profile-info">
	                                        <h3>Vivian 何老师个人介绍</h3>
	                                    </div>
	                                    <p>
	                                  		Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo.
	                                    </p>
	                                    <div class="spacer"></div>
	                              </div>
                              </div>
                              
                               <div class="vs-news-content">
	                             <div class="col-xs-3">
	                                    <div class="profile-pic text-center">
	                                        <img src="assets/img/team-1.jpg" alt="" class="img-circle">
	                                    </div>
	                             </div>
	                             <div class="col-xs-9">
	                                    <div class="profile-info">
	                                        <h3>往届学员有话说</h3>
	                                    </div>
	                                    <p>
	                                  		Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo.
	                                    </p>
	                                    <div class="spacer"></div>
	                              </div>
                              </div>
                              
                              <div class="vs-news-content">
	                             <div class="col-xs-3">
	                                    <div class="profile-pic text-center">
	                                        <img src="assets/img/team-4.jpg" alt="" class="img-circle">
	                                    </div>
	                             </div>
	                             <div class="col-xs-9">
	                                    <div class="profile-info">
	                                        <h3>我要加入｜即刻在线报名</h3>
	                                    </div>
	                                    <p>
	                                  		Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo.
	                                    </p>
	                                    <div class="spacer"></div>
	                              </div>
                              </div>
                         </div>
            		</div>
            	</div>
            	
            </div>
           </div>
         </section>
    

    <!-- Contact
    ================================================== -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 text-center">
                    <header>
                        <h1>联系我们</h1>
                        <div class="spacer"></div>
                        <p>欢迎加入我们 ｜ Vivian Studio</p>
                    </header>
                </div>
            </div>
            <div class="row">
                <div class="col-md-11 col-md-offset-1 col-sm-12 col-xs-12">
                    <div class="row">
                        <div class="col-sm-4 col-md-4 col-lg-4 text-center">
                            <div class="contact-info">
                                <i class="fa fa fa-envelope"></i>
                                <span>support@authenticgoods.co</span>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-4 text-center">
                            <div class="contact-info">
                                <i class="fa fa fa-phone"></i>
                                <span>(800) 123-4567</span>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-4 text-center">
                            <div class="contact-info">
                                <i class="fa fa-twitter"></i>
                                <span>@_authenticgoods</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </section>

    <!-- Footer
    ================================================== -->
    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-xs-4 col-sm-6 col-md-6 col-lg-6">
                    <p class="copy">VivanStudio &copy; 2015</p>
                </div>
            </div>
    </footer>

<script type="text/javascript">
    $('#myCarousel').carousel()
</script>

</body>

</html>