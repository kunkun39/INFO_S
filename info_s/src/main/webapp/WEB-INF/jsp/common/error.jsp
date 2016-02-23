<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
	<title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8" />
    <c:import url="csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
	<link href="${pageContext.request.contextPath}/media/css/error.css" rel="stylesheet" type="text/css"/>
</head>

<body class="page-404-3">
	<div class="page-inner">
		<img src="${pageContext.request.contextPath}/media/image/earth.jpg" alt="">
	</div>
	<div class="container error-404">
		<h1>oops!</h1>
		<h2>对不起, 系统错误.</h2>
		<p>
			稍后我们将会对该错误进行处理，给你带来的不便请谅解！
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/system/dashboard.html">返回</a>
			<br>
		</p>
	</div>

    <c:import url="jspart.jsp"/>
	<script src="${pageContext.request.contextPath}/media/js/app.js"></script>

	<script>
		jQuery(document).ready(function() {
		   App.init();
		});
	</script>

	<!-- END JAVASCRIPTS -->

</body>

</html>
