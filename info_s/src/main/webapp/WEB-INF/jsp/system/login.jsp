<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
	<title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8" />
    <c:import url="../common/csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="${pageContext.request.contextPath}/media/css/login.css" rel="stylesheet" type="text/css"/>
</head>

<body class="login">

	<!-- BEGIN LOGO -->
	<div class="logo">
		<img src="${pageContext.request.contextPath}/media/image/logo-big.png" alt="" />
	</div>
	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
			<h3 class="form-title">请输入账户信息</h3>

            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                <div class="alert alert-error">
                    <button class="close" data-dismiss="alert"></button>
                    <span>账户信息不正确，请确认后再输入!</span>
                </div>
            </c:if>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="j_username"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="j_password"/>
					</div>
				</div>
			</div>

			<div class="form-actions">
				<button type="submit" class="btn green pull-right">
				登录 <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
		<!-- END LOGIN FORM -->
	</div>
	<!-- END LOGIN -->

	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">
		2016 &copy; 四川长虹网络有限责任公司
	</div>

    <c:import url="../common/jspart.jsp"/>
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script src="${pageContext.request.contextPath}/media/js/jquery.validate.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="${pageContext.request.contextPath}/media/js/app.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/media/js/login.js" type="text/javascript"></script>
</body>

</html>
