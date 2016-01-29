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
                        <a href="home" class="logo">
                            <i class="icon-diamond"></i>
                            <span>Vivian</span>Studio</a>
                    </div>
                </header>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">     
                       登 录
                    </h3>
                    </div>
                    <div class="panel-body">
                        <p> 登录账号</p>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="email" class="form-control" id="email" placeholder="请输入您的账户">
                                    <i class="fa fa-user"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="password" class="form-control" id="password" placeholder="请输入您的密码">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <a id="loginBtn" href="#" class="btn btn-primary btn-block">登录</a>
                                    <hr />
                                    <a href="registerPage" class="btn btn-default btn-block">立即注册</a>
                                </div>
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
        $("#loginBtn").click(function(e) {
            var mail = $("#email").val();
            var password = $("#password").val();

            if(mail == undefined || mail.trim() == "") {
                showMessage("请输入用户名", "请输入用户名");
                return;
            }

            if(password == undefined || password.trim() == "") {
                showMessage("请输入密码", "请输入密码");
                return;
            }

            $.ajax({
                url:"login",
                method:"post",
                data:{
                    mail:mail,
                    password:password
                },
                success:function(r) {
                    if(r.code == 0) {
                        window.location = r.data;    
                    }else {
                        showMessage("登录失败", "登录失败，请重试!");
                    }
                }
            });
            
        });
    });
</script>

</body>

</html>
