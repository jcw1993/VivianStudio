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
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--logo start-->
                    <div class="brand">
                        <a href="home" class="logo">
                            <i class="icon-layers"></i>
                            <span>Vivian</span>Studio</a>
                    </div>
                    <!--logo end-->
                    
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav pull-right" id="main-menu">
                        <li><a href="#home">首页</a>
                        </li>
                        <li><a href="#schedule">课程安排</a>
                        </li>
                        <li><a href="#show">风采展示</a>
                        </li>
                        <li><a href="#contact">联系我们</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </header>

    <section id="home">
        <div class="overlay-bg">
            <div class="container">
                <div class="hero">
                    <div class="row">
                        <div class="col-xs-6 col-sm-8 col-md-5 col-lg-5 wow pulse">
                            <header class="wow fadeInLeft">
                                <h1>欢迎来到</h1>
                            </header>
                            <header class="wow fadeInRight">
                                <h1>VivianStudio</h1>
                            </header>
                            <header class="wow fadeInTop">
                                <a class="btn btn-success btn-trans btn-lg" href="javascript:window.location='loginPage'" role="button">马上报名</a>
                            </header>
                        </div>
                        <div class="hidden-xs hidden-sm col-md-7 col-lg-7">
                            <img src="assets/img/laptop.png" class="wow fadeInRight" alt="laptop">
                        </div>
                        <div class="col-xs-6 col-sm-4 hidden-md hidden-lg">
                            <img src="assets/img/mobile.png" class="wow fadeInRight" alt="mobile">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>

    </section>


    <!-- Schedule Section
    ================================================== -->
    <section id="schedule">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <img src="http://img02.taobaocdn.com/imgextra/i3/143770146417445852/TB2lB_LhVXXXXaYXpXXXXXXXXXX_!!100144377-0-taokezhan.jpg">
                </div>
            </div>
        </div>
    </section>

    <!-- Show
    ================================================== -->
    <section id="show">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <header>
                        <h1>风采展示</h1>
                    </header>
                </div>
            </div>
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

    <!-- Contact
    ================================================== -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 text-center">
                    <header>
                        <h1>Contact Us</h1>
                        <div class="spacer"></div>
                        <p>Lorem ipsum dolor sit amet, id iusto oportere mel. </p>
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


            <form class="contact-form">
                <div class="row">
                    <div class="col-md-5 col-md-offset-1 col-sm-12 col-xs-12">
                        <div class="row">
                            <div class="form-group">
                                <div class="col-md-12 col-sm-4 col-xs-12">
                                    <input type="text" class="form-control" name="name" value="" required="true" placeholder="Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-sm-4 col-xs-12">
                                    <input type="email" class="form-control" name="your-email" value="" required="true" placeholder="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-sm-4 col-xs-12">
                                    <input type="text" class="form-control" name="your-subject" value="" required="true" placeholder="Subject">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5 col-sm-12 col-xs-12">

                            <textarea class="form-control" name="your-message" cols="40" rows="8" placeholder="Message"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-11 col-sm-12 col-xs-12 text-right">
                            <input type="submit" value="Submit" class="btn btn-success">
                        </div>
                    </div>
                </div>
            </form>
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