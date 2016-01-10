<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp" flush="true"/>

<body>
<section class="container animated fadeInUp">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div id="login-wrapper">
                <header>
                    <div class="brand">
                        <a href="index.html" class="logo">
                            <i class="icon-layers"></i>
                            <span>Vivian</span>Studio</a>
                    </div>
                </header>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">     
                       注 册
                    </h3>
                    </div>
                    <div class="panel-body">
                        <p> 注册账号</p>
                        <form id="editForm" class="form-horizontal form-border" id="form">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">姓名</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="name" name="name" placeholder="姓名"/>   
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">密码</label>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control" id="password2" name="password" placeholder="密码" />  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">确认密码</label>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control" id="confirmPassword" placeholder="重复密码" />  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">性别</label>
                                    <div class="col-sm-6">
                                        <select name="sex" class="form-control">
                                            <option value="男">男</option>
                                            <option value="女">女</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">年级</label>
                                    <div class="col-sm-6">
                                        <select name="levelId" class="form-control">
                                            <option value="1">初一</option>
                                            <option value="2">初二</option>
                                            <option value="3">初三</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">邮箱</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="mail" name="mail" placeholder="邮箱" />   
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">QQ</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ号"  />    
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">手机</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号" />   
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">地址</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="address" name="address" placeholder="地址" />  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">邀请码</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="invitationCode" name="invitationCode" placeholder="邀请码" />  
                                    </div>
                                </div>
                                <div class="form-group">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-6"><button type="button" class="btn btn-primary btn-block" onclick="javascript:register();">注册</button></div>
                                <div class="col-sm-3"></div>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="modal.jsp" flush="true" />
       
<script type="text/javascript">
$(function() {

});

function register() {
    
    if(validate()) {
        var data = $("#editForm").serialize();
        $.ajax({
            url: "register",
            type: "post",
            data: data,
            success: function(r) {
                if(r.code == 0) {
                    window.location = "loginPage";
                }else if(r.code == 0x00000042) {
                    showMessage("邀请码不正确", "邀请码不正确");
                }else {
                    showMessage("注册失败", "注册失败");
                }
            }
        });
    }
}

function validate() {
    var name = $("#name").val();
    var password = $("#password2").val();
    var confirmPassword = $("#confirmPassword").val();
    var sex = $("#sex").val();
    var mail = $("#mail").val();
    var qq = $("#qq").val();
    var phone = $("#phone").val();
    var adderss = $("#address").val();
    var invitationCode = $("#invitationCode").val();

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
    if(!invitationCode || invitationCode.trim() == "") {
        showMessage("请输入邀请码", "请输入邀请码");
        return false;
    }

    return true;
}

</script>

</body>

</html>
