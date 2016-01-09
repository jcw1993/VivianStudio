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
                        <li><a href="home">首页</a>
                        </li>
                        <li><a href="schedule">课程安排</a>
                        </li>
                        <li><a href="#show">风采展示</a>
                        </li>
                        <li><a href="contact">联系我们</a>
                        </li>
                        <li class="pull-right"><a href="#contact">登录</a>
                        </li>
                    </ul>
<!--                 </div>
 -->            </div>
        </div>
    </header>

	<!-- Schedule Section
    ================================================== -->
    <section id="schedule">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <iframe src="http://3gimg.qq.com/lightmap/v1/wxmarker/index.html?marker=coord:31.55895,120.30306;title:%E8%8B%B1%E8%AF%AD%E5%9F%B9%E4%BC%98Vivian%E5%B7%A5%E4%BD%9C%E5%AE%A4;addr:%E6%97%A0%E9%94%A1%E5%B8%82%E5%8D%97%E9%95%BF%E5%8C%BA%E6%B8%85%E6%89%AC%E8%B7%AF%E6%B0%B8%E4%B8%B0%E5%A4%A7%E5%8E%A61503%E5%AE%A4&referer=wexinmp_profile" 
                    width="100%" height="370px" frameborder="0" scrolling="no"></iframe>
                </div>
            </div>
        </div>
    </section>



    <jsp:include page="feature.jsp" flush="true"/>
	<jsp:include page="footer.jsp" flush="true"/>
   
<script type="text/javascript">
    $('#myCarousel').carousel()
</script>

</body>

</html>
    


    
