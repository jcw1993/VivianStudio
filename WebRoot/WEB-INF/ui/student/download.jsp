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
		    <h1>课件下载</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">课件列表</h3>
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
                                        <th>课件名称</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <c:if test="${materials != null}">
                                <tbody>
                                <c:forEach items="${materials}" var="material">
                                    <tr>
                                        <td>${material.title}</td>
                                        <td><a href="${material.url}">下载</a></td>
                                    </tr>
               					</c:forEach>
                                </tbody>
                                </c:if>
                            </table>
                        </div>
		            </div>
		        </div>
		    </div>
		    <jsp:include page="pagination.jsp" flush="true" />
		</section>
    </section>
    <!--main content end-->
</section>
<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(3)").addClass("active");
});
</script>

</body>

</html>