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
							<li><a href="javascript:;">从数据库服务器编辑</a></li>
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
								<div class="caption"><i class="icon-reorder"></i>从数据库服务器信息</div>
							</div>

							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<spring-form:form commandName="subDBConf" id="form_sample_2" class="form-horizontal">
									<div class="alert alert-error hide">
										<button class="close" data-dismiss="alert"></button>
										You have some form errors. Please check below.
									</div>

									<div class="alert alert-success hide">
										<button class="close" data-dismiss="alert"></button>
										Your form validation is successful!
									</div>

                                    <input type="hidden" name="id" value="${subDBConf.id}"/>
									<div class="control-group">
										<label class="control-label">服务器地址<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input path="host" maxlength="30" cssClass="span6 m-wrap"/>&nbsp;
                                            <span class="help-inline">
                                                <spring-form:errors path="host"/>
                                            </span>
										</div>
									</div>

                                    <div class="control-group">
										<label class="control-label">服务器端口<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input path="port" maxlength="5" cssClass="span6 m-wrap"/>&nbsp;
                                            <span class="help-inline">
                                                <spring-form:errors path="port"/>
                                            </span>
										</div>
									</div>

                                    <div class="control-group">
										<label class="control-label">服务器名称<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input path="dbName" maxlength="30" cssClass="span6 m-wrap"/>&nbsp;
                                            <span class="help-inline">
                                                <spring-form:errors path="dbName"/>
                                            </span>
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
