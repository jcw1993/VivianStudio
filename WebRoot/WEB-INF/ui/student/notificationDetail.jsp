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

    </section>
    <!--main content end-->
</section>

<script type="text/javascript">
$(function() {
	$("#leftNav li:nth-child(5)").addClass("active");

});
</script>

</body>

</html>