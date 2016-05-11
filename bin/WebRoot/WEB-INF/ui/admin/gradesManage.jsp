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
		    <h1>成绩管理</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">成绩列表</h3>
		                    <div class="actions pull-right">
		                   		<select id="levelSelect">
		                    		<option value="1" <c:if test="${levelId == 1}">selected="selected"</c:if>>初一</option>
		                    		<option value="2" <c:if test="${levelId == 2}">selected="selected"</c:if>>初二</option>
		                    		<option value="3" <c:if test="${levelId == 3}">selected="selected"</c:if>>初三</option>
		                    	</select>
		                        <button id="createBtn" type="button" class="btn btn-success btn-sm">发布成绩</button>
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
                                        <button type="button" class="deleteBtn btn btn-danger btn-sm btn-trans" gradesId="${grades.id}">删除</button>
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
    </section>
    <!--main content end-->
</section>

<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(1)").addClass("active");


	$("#createBtn").click(function(e) {
		location.href = "createGradesPage";
	});

	$(".deleteBtn").click(function(e) {
		var gradesId = $(this).attr("gradesId");
		$.ajax({
			url: "deleteGrades",
			method: "post",
			data: {
				gradesId: gradesId
			},
			success: function(r) {
				if(r.code == 0) {
					window.location = "gradesManage?levelId=${levelId}"
				}else {
					showMessage("删除失败", "删除失败，请重试！");
				}
			}
		});
	});

	$("#levelSelect").change(function(e) {
		var levelId = $(this).val();
		window.location = "gradesManage?levelId=" + levelId;
	});
});
</script>
</body>

</html>