<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="studentHeader.jsp" flush="true"/>
<body>
<section id="main-wrapper" class="theme-default">
    <jsp:include page="studentNav.jsp" flush="true" />

    <!--main content start-->
    <section class="main-content-wrapper">
        <div class="pageheader">
		    <h1>我的成绩</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">成绩列表</h3>
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
                                        <th>标题</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <c:if test="${gradesList != null}">
                                <tbody>
                                <c:forEach items="${gradesList}" var="grades">
                                    <tr>
                                        <td>${grades.title}</td>
                                        <td>
                                        <a href="${grades.url}" class="deleteBtn btn btn-success btn-sm btn-trans" gradesId="${grades.id}">下载</a>
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
		</section>
    </section>
    <!--main content end-->
</section>

<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(1)").addClass("active");
});
</script>
</body>

</html>