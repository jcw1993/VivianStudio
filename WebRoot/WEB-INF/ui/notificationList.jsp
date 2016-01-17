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
		                    <h3 class="panel-title">通知列表</h3>
		                </div>
		                <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>标题</th>
                                        <th>发布时间</th>
                                        <th>点击</th>
                                    </tr>
                                </thead>
                                <c:if test="${notifications != null}">
                                <tbody>
                                <c:forEach items="${notifications}" var="notification">
                                    <tr>
                                        <td>${notification.title}</td>
                                        <td>
                                        	<p><fmt:formatDate value="${notification.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                                        </td>
                                        <td>
                                        <button type="button" class="detailBtn btn btn-success btn-sm btn-trans" notificationId="${notification.id}">查看详情</button>
                                        </td>
                                    </tr>
               					</c:forEach>
                                </tbody>
                                </c:if>
                            </table>
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

	$(".detailBtn").click(function(e) {
		var notificationId = $(this).attr("notificationId");
		window.location = "notificationDetail?notificationId=" + notificationId;
	});
});
</script>

</body>

</html>