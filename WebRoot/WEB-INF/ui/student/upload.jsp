<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="studentHeader.jsp" flush="true"/>
<body>
<section id="main-wrapper" class="theme-default">
    <jsp:include page="studentNav.jsp" flush="true" />

    <!--main content start-->
    <section class="main-content-wrapper">
        <div class="pageheader">
		    <h1>作业上传</h1>
		</div>
		<section id="main-content" class="animated fadeInUp">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    <h3 class="panel-title">作业上传</h3>
		                    <div class="actions pull-right">
		                        <i class="fa fa-expand"></i>
		                        <i class="fa fa-chevron-down"></i>
		                    </div>
		                </div>
		                <div class="panel-body">
                            <form class="form-horizontal form-border" id="form">
                                <div class="form-group">
                                    <label id="titleLbl" for="title" class="col-sm-3 control-label">标题</label>
                                    <div class="col-sm-6">
                                       <input type="text" class="form-control" name="title" id="title" placeholder="输入标题" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="homework">文件</label>
                                    <div class="col-sm-6">
										<!-- <input type="file" id="homework" class="form-control" /> -->
										<span class="file-input btn btn-block btn-primary btn-file">选择 <input type="file" multiple="">
							            </span>
                                    </div>
                                </div>
                                <div class="form-group">
	                                <div class="col-sm-3"></div>
	                                <div class="col-sm-6"><button type="button" class="btn btn-success btn-block" onclick="javascript:upload();">上传</button></div>
	                                <div class="col-sm-3"></div>
                                </div>
                            </form>
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
	$("#leftNav li:nth-child(2)").addClass("active");
});

function upload() {

}
</script>

</body>

</html>