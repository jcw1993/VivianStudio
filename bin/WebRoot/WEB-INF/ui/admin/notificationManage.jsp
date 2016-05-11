<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="adminHeader.jsp" flush="true"/>
<body>
<section id="main-wrapper" class="theme-default">
    <jsp:include page="adminNav.jsp" flush="true" />

    <!--main content start-->
    <section class="main-content-wrapper">
        <div class="pageheader">
		    <h1>通知管理</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">通知列表</h3>
		                    <div class="actions pull-right">
		                        <button id="createBtn" type="button" class="btn btn-success btn-sm">发布通知</button>
		                    </div>
		                </div>
		                <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>标题</th>
                                        <th>内容</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <c:if test="${notifications != null}">
                                <tbody>
                                <c:forEach items="${notifications}" var="notification">
                                    <tr>
                                        <td>${notification.title}</td>
                                        <td>${notification.content}</td>
                                        <td>
                                        <button type="button" class="deleteBtn btn btn-danger btn-sm btn-trans" notificationId="${notification.id}">删除</button>
                                        </td>
                                    </tr>
               					</c:forEach>
                                </tbody>
                                </c:if>
                            </table>
                        </div>
		            </div>
		        </div>
		    </div>
		    <jsp:include page="../pagination.jsp" flush="true" />
		</section>
    </section>
    <!--main content end-->
</section>

<jsp:include page="../modal.jsp" flush="true" />

<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(3)").addClass("active");

	$(".deleteBtn").click(function(e) {
		var notificationId = $(this).attr("notificationId");
		$.ajax({
			url: "deleteNotification",
			method: "post",
			data: {
				notificationId: notificationId
			},
			success: function(r) {
				if(r.code == 0) {
					location.reload();
				}else {
					showMessage("删除失败", "删除失败，请重试！");
				}
			}
		});
	});

	$("#createBtn").click(function(e) {
		location.href = "createNotificationPage";
	});

});
</script>
</body>

</html>