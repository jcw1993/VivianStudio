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
            <h1>个人信息</h1>
        </div>
        <section id="main-content" class="animated fadeInUp">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">详情</h3>
                            <div class="actions pull-right">
                                <button id="backBtn" type="button" class="btn btn-success btn-sm">返回</button>
                            </div>
                        </div>
                        <div class="panel-body">
                            <form id="editForm" class="form-horizontal form-border" id="form">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">姓名</label>
                                    <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="name" name="name" placeholder="姓名" value="${student.name}" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">密码</label>
                                    <div class="col-sm-6">
	                                    <input type="password" class="form-control" id="password" name="password" value="${student.password}" placeholder="密码" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">确认密码</label>
                                    <div class="col-sm-6">
	                                    <input type="password" class="form-control" id="confirmPassword" value="${student.password}" placeholder="重复密码" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">性别</label>
                                    <div class="col-sm-6">
                                    	<select name="sex" class="form-control">
                                        	<option value="男" <c:if test="${student.sex == '男'}">selected="selected"</c:if> >男</option>
                                        	<option value="女" <c:if test="${student.sex == '女'}">selected="selected"</c:if>>女</option>
                                    	</select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">年级</label>
                                    <label id="levelLbl" class="col-sm-6 control-label">levelMap["${student.levelId}"]</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">邮箱</label>
                                    <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="mail" name="mail" placeholder="邮箱" value="${student.mail}" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">QQ</label>
                                    <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ号" value="${student.qq}" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">手机</label>
                                    <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号" value="${student.phone}" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">地址</label>
                                    <div class="col-sm-6">
	                                    <input type="text" class="form-control" id="address" name="address" placeholder="地址" value="${student.address}" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6"><button type="button" class="btn btn-primary btn-block" onclick="javascript:updateInfo();">保存修改</button></div>
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

<jsp:include page="../modal.jsp" flush="true"/>
<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(4)").addClass("active");

	var level = levelMap[${student.levelId}];
	$("#levelLbl").text(level);

    $("#backBtn").click(function(e) {
        window.location = "profile";
    });
});

function validate() {
	var name = $("#name").val();
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();
    var sex = $("#sex").val();
    var mail = $("#mail").val();
    var qq = $("#qq").val();
    var phone = $("#phone").val();
    var adderss = $("#address").val();

    if(!name || name.trim() == "") {
    	showMessage("姓名不能为空", "姓名不能为空");
    	return false;
    }

    if(!password || password.trim() == "") {
    	showMessage("密码不能为空", "密码不能为空");
    	return false;
    }
    if(!confirmPassword || confirmPassword.trim() == "") {
    	showMessage("请确认密码", "请确认密码");
    	return false;
    }
    if(!mail || mail.trim() == "") {
    	showMessage("请填写邮箱", "请填写邮箱");
    	return false;
    }
    if(!phone || phone.trim() == "") {
    	showMessage("请填写手机号", "请填写手机号");
    	return false;
    }

    return true;
}

function updateInfo() {
	var data = $("#editForm").serialize();
	if(validate()) {
		$.ajax({
			url: "updateProfile",
			type: "post",
			data: data,
			success: function(r) {
				if(r.code == 0) {
					window.location = "profile";
				}else {
					showMessage("保存失败", "保存失败");
				}
			}
		});
	}


}
</script>

</body>

</html>