 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header id="header">
    <!--logo start-->
    <div class="brand">
        <a href="gradesManage" class="logo">
            <i class="icon-diamond"></i>
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
	            <span class="text">管理员</span>
	            <span class="caret"></span>
	            </span>
	        </a>
	        <ul class="dropdown-menu animated fadeInRight" role="menu">
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
                <a href="gradesManage" title="成绩发布">
                    <i class="fa  fa-fw"></i> 成绩管理
                </a>
            </li>
            <li>
                <a href="materialManage" title="课件管理">
                    <i class="fa  fa-fw"></i> 课件管理
                </a>
            </li>
			<li>
                <a href="studentManage" title="学员管理">
                    <i class="fa  fa-fw"></i> 学员管理
                </a>
            </li>
			<li>
                <a href="notificationManage" title="通知管理">
                    <i class="fa  fa-fw"></i> 通知管理
                </a>
            </li>
            <!-- 
			<li>
                <a href="homeworkManage" title="作业查看">
                    <i class="fa  fa-fw"></i> 作业查看
                </a>
            </li>
            -->
        </ul>
    </nav>
</aside>
<!--sidebar left end-->
