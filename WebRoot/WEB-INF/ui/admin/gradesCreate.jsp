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
		    <h1>发布成绩</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">发布成绩</h3>
		                </div>
		                <div class="panel-body">
                            <form id="editForm" action='createNotification' class='form-horizontal' role='form' method='post'>
                               	<div class='form-group'>
	                               	<label class="col-sm-3 control-label" for="homework">标题</label>
                               	    <div class='col-sm-6'>
                               	        <input type='text' class='form-control' id='title' name='title' placeholder='标题'>
                               	    </div>
                               	</div>
           	                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="homework">年级</label>
                                    <div class="col-sm-6">
										<select name="levelId" class="form-control input-default">
											<option value="1">初一</option>
											<option value="2">初二</option>
											<option value="3">初三</option>
										</select>	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="homework">文件地址</label>
                                    <div class="col-sm-6">
										<input id="url" class="form-control" type="text" name="url" placeholder="成绩文件url"/>
                                    </div>
                                </div>
                               	<div class="form-group">
	                               	<div class="col-sm-3"></div>
                               	    <div class="col-sm-6">
                               	        <a id="createBtn" href="#" class="btn btn-primary btn-block">发布</a>
                               	    </div>
                               	</div> 
                           	</form>
                        </div>
		            </div>
		        </div>
		    </div>
		</section>
    </section>
    <!--main content end-->
    <jsp:include page="../modal.jsp" flush="true" />
</section>

<script type="text/javascript">
$(function() {
	$("#createBtn").click(function(e) {
		create();
	});
});

function create() {
	var data = $("#editForm").serialize();
	if(validate()) {
		$.ajax({
			url: "createGrades",
			type: "post",
			data: data,
			success:function(r) {
				if(r.code == 0) {
					window.location = "gradesManage";
				}else {
					showMessage("发布失败", "发布失败");
				}
			}
		});
	}
}

function validate() {
	var title = $("#title").val();
	var url = $("#url").val();
	
	if(!title || title.trim() == "") {
		showMessage("请输入标题", "请输入标题");
		return false;
	}

	if(!url || url.trim() == "") {
		showMessage("请输入文件url", "请输入文件url");
		return false;
	}

	return true;
}
</script>
</body>

</html>