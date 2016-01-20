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
		    <h1>创建课件</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">创建课件</h3>
		                </div>
		                <div class="panel-body">
                            <form id="editForm" action='createGrades' class='form-horizontal' role='form' method='post'>
                               	<div class='form-group'>
	                               	<label class="col-sm-3 control-label">标题</label>
                               	    <div class='col-sm-6'>
                               	        <input type='text' class='form-control' id='title' name='title' placeholder='标题'>
                               	    </div>
                               	</div>
           	                    <div class="form-group">
                                    <label class="col-sm-3 control-label">年级</label>
                                    <div class="col-sm-6">
										<select name="levelId" class="form-control input-default">
											<option value="1">初一</option>
											<option value="2">初二</option>
											<option value="3">初三</option>
										</select>	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">文件</label>
                                    <div class="col-sm-6">
										<span class="file-input"> <input id="file" type="file" name="file" />
							            </span>
                                    </div>
                                </div>
                               	<div class="form-group">
	                               	<div class="col-sm-3"></div>
                               	    <div class="col-sm-6">
                               	        <a id="createBtn" href="#" type="submit" class="btn btn-primary btn-block">创建</a>
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
		$("#editForm").submit();
	});

	$("#editForm").submit(function() {
		if(validate()) {
			// ajax 上传 file文件
			var formData = new FormData(this);
			console.log("formData： " + formData);
			$.ajax({
				url: "createMaterialPost",
				type: "post",
				data: formData,
				processData: false,
			    contentType: false,
				success:function(r) {
					if(r.code == 0) {
						window.location = "materialManage";
					}else {
						showMessage("发布失败", "发布失败");
					}
				}
			});
		}
	    return false;
	});
});

function validate() {
	var title = $("#title").val();
	if(!title || title.trim() == "") {
		showMessage("请输入标题", "请输入标题");
		return false;
	}

	var fileName = $("#file").val();
	if(!fileName || fileName.trim() == "") {
		showMessage("请选择文件", "请选择文件");
		return false;
	}
	var fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
	if($.inArray(fileSuffix, validFileSuffix) == -1) {
		showMessage("文件格式不支持", "文件格式不支持");
		return false;
	}
	return true;
}
</script>
</body>

</html>