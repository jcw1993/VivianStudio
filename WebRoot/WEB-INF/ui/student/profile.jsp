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
            <h1>个人信息</h1>
        </div>
        <section id="main-content" class="animated fadeInUp">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">详情</h3>
                            <div class="actions pull-right">
                                <button id="editBtn" type="button" class="btn btn-success btn-sm">编辑</button>
                            </div>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal form-border" id="form">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">姓名</label>
                                    <label class="col-sm-6 control-label">${student.name}</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">性别</label>
                                    <label class="col-sm-6 control-label">${student.sex}</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">年级</label>
                                    <label id="levelLbl" class="col-sm-6 control-label">levelMap["${student.levelId}"]</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">邮箱</label>
                                    <label class="col-sm-6 control-label">${student.mail}</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">手机</label>
                                    <label class="col-sm-6 control-label">${student.phone}</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">QQ</label>
                                    <label class="col-sm-6 control-label">${student.qq}</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">地址</label>
                                    <label class="col-sm-6 control-label">${student.address}</label>
                                </div>
                                <div class="form-group">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6"><button type="button" class="btn btn-danger btn-block" onclick="javascript:logout();">注销登录</button></div>
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
	$("#leftNav li:nth-child(4)").addClass("active");

    var level = levelMap[${student.levelId}];
    $("#levelLbl").text(level);

    $("#editBtn").click(function(e) {
        window.location = "profileEdit";
    });
});
</script>

</body>

</html>