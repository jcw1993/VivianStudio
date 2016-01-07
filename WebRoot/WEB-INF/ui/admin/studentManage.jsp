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
		    <h1>学生管理</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">学生列表</h3>
		                    <div class="actions pull-right">
		                        <i class="fa fa-expand"></i>
		                        <i class="fa fa-chevron-down"></i>
		                        <i class="fa fa-times"></i>
		                    </div>
		                </div>
		                <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>年级</th>
                                        <th>手机</th>
                                        <th>邮箱</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <c:if test="${students != null}">
                                <tbody>
                                <c:forEach items="${students}" var="student">
                                    <tr>
                                        <td>${student.name}</td>
                                        <td>${student.sex}</td>
                                        <td>${student.levelId}</td>
                                        <td>${student.phone}</td>
                                        <td>${student.mail}</td>
                                        <td><button type="button" class="deleteBtn btn btn-danger btn-sm btn-trans" studentId="${student.id}">删除</button></td>
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
	$("#leftNav li:nth-child(2)").addClass("active");

    $(".deleteBtn").click(function(e) {
        var studentId = $(this).attr("studentId");
        $.ajax({
            url: "deleteStudent",
            method: "post",
            data: {
                studentId: studentId
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
});
</script>
</body>

</html>