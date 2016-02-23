<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8" />
    <c:import url="../../common/csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/chosen.css" />
</head>

<body class="page-header-fixed">
    <c:import url="../../common/header.jsp"/>

    <!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<c:import url="../../common/menu.jsp"/>
		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->
        <div class="page-content">
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
                        <br/>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="${pageContext.request.contextPath}/system/dashboard.html">首页</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="javascript:;">用户编辑</a></li>
						</ul>
					</div>
				</div>
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN VALIDATION STATES-->
						<div class="portlet box green">
							<div class="portlet-title">
								<div class="caption"><i class="icon-reorder"></i>用户信息</div>
							</div>

							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<spring-form:form commandName="user" id="form_sample_2" class="form-horizontal">
									<div class="alert alert-error hide">
										<button class="close" data-dismiss="alert"></button>
										You have some form errors. Please check below.
									</div>

									<div class="alert alert-success hide">
										<button class="close" data-dismiss="alert"></button>
										Your form validation is successful!
									</div>

									<div class="control-group">
										<label class="control-label">姓名<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input path="name" maxlength="30" cssClass="span6 m-wrap"/>&nbsp;
                                            <span class="help-inline">
                                                <spring-form:errors path="name"/>
                                            </span>
										</div>
									</div>

                                    <div class="control-group">
										<label class="control-label">员工编号<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input path="username" maxlength="30" cssClass="span6 m-wrap"/>&nbsp;
                                            <spring-form:errors path="username" cssClass="help-inline"/>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">联系方式<span class="required">*</span></label>
										<div class="controls">
											<spring-form:input path="contactWay" maxlength="30" cssClass="span6 m-wrap"/>&nbsp;
                                            <spring-form:errors path="contactWay" cssClass="help-inline"/>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">系统角色<span class="required">*</span></label>
										<div class="controls">
											<label class="radio line">
											<input type="radio" name="membership" value="1" />
											系统管理员
											</label>
											<label class="radio line">
											<input type="radio" name="membership" value="2" />
											项目管理员
											</label>
										</div>
									</div>

									<div class="form-actions">
                                        <button type="button" class="btn yellow">返回</button>
                                        <button type="submit" class="btn blue">保存</button>
									</div>
								</spring-form:form>
								<!-- END FORM-->
							</div>
						</div>
						<!-- END VALIDATION STATES-->

					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->

		</div>
		<!-- END PAGE -->

	</div>
	<!-- END CONTAINER -->

    <c:import url="../../common/jspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
	<script src="${pageContext.request.contextPath}/media/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/media/js/form-validation.js"></script>
	<!-- END PAGE LEVEL STYLES -->

    <script>
       jQuery(document).ready(function() {
		   App.init();
		   FormValidation.init();
		});
	</script>
</body>

</html>
