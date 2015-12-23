<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header id="header">
    <!--logo start-->
    <div class="brand">
        <a href="index.html" class="logo">
            <i class="icon-layers"></i>
            <span>VIVIAN</span>STUDIO</a>
    </div>
    <!--logo end-->
    <ul class="nav navbar-nav navbar-left">
        <li class="toggle-navigation toggle-left">
            <button class="sidebar-toggle" id="toggle-left">
                <i class="fa fa-bars"></i>
            </button>
        </li>
    </ul>

	<ul class="nav navbar-nav navbar-right">
	    <li class="dropdown profile hidden-xs">
	        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
	            <span class="meta">
	            <span class="text">金程炜</span>
	            <span class="caret"></span>
	            </span>
	        </a>
	        <ul class="dropdown-menu animated fadeInRight" role="menu">
	            <li>
	                <a href="javascript:void(0);">
	                    <span class="icon"><i class="fa fa-user"></i>
	                    </span>个人信息</a>
	            </li>
	            <li>
	                <a href="javascript:logout();">
	                    <span class="icon"><i class="fa fa-sign-out"></i>
	                    </span>注销</a>
	            </li>
	        </ul>
	    </li>
	</ul>
</header>
<!--sidebar left start-->
<aside class="sidebar sidebar-left">
    <nav>
        <h5 class="sidebar-header"></h5>
        <ul id="leftNav" class="nav nav-pills nav-stacked">
 			<li>
                <a href="grades" title="我的成绩">
                    <i class="fa  fa-fw fa-list"></i> 我的成绩
                </a>
            </li>
			<li>
                <a href="uploadPage" title="作业上传">
                    <i class="fa  fa-fw fa-cloud-upload"></i> 作业上传
                </a>
            </li>
			<li>
                <a href="download" title="课件下载">
                    <i class="fa  fa-fw fa-cloud-download"></i> 课件下载
                </a>
            </li>
			<li>
                <a href="profile" title="个人信息">
                    <i class="fa  fa-fw fa-user"></i> 个人信息
                </a>
            </li>
        </ul>
    </nav>
</aside>
<!--sidebar left end-->

<script type="text/javascript">
function logout() {
	$.ajax({
		url:"../logout",
		method:"post",
		success:function(r) {
			if(r.code == 0) {
				window.location = "../home";
			}
		}
	});
}	
</script>