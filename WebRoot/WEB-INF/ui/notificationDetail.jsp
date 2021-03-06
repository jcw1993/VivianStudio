<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp" flush="true"/>
<body>
<section id="main-wrapper" class="theme-default">
    <jsp:include page="navi.jsp" flush="true" />

    <!--main content start-->
    <section class="main-content-wrapper">
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-1"></div>
		        <div class="col-md-10">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">通知详情</h3>
		                </div>
		                <div class="panel-body">
                            <h1>${notification.title}</h1><br/>
							<h5><fmt:formatDate value="${notification.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h5> <br/>
							<p>${notification.content}</p>
                        </div>
		            </div>
		        </div>
		        <div class="col-md-1"></div>
		    </div>
		</section>
    </section>
    <!--main content end-->
</section>

<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(5)").addClass("active");

});
</script>

</body>

</html>