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
							<li>
                                <a href="${pageContext.request.contextPath}/system/dbsetting.html">存储服务器管理</a>
                                <i class="icon-angle-right"></i>
                            </li>
							<li>
                                <a href="${pageContext.request.contextPath}/system/bakuphistoryoverview.html?dbConfId=${dbConfId}">服务器备份历史</a>
                                <i class="icon-angle-right"></i>
                            </li>
							<li><a href="javascript:;">服务器数据备份</a></li>
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
								<div class="caption"><i class="icon-reorder"></i>服务器数据备份</div>
							</div>

							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<spring-form:form commandName="history" id="form_sample_2" class="form-horizontal" method="post">
									<div class="alert alert-error hide">
										<button class="close" data-dismiss="alert"></button>
										You have some form errors. Please check below.
									</div>

									<div class="alert alert-success hide">
										<button class="close" data-dismiss="alert"></button>
										Your form validation is successful!
									</div>

									<div class="control-group">
										<label class="control-label">备份的工程<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input path="projectCode" maxlength="5" cssClass="span6 m-wrap"/>&nbsp;
										</div>
									</div>

                                    <div class="control-group">
										<label class="control-label">备份的年份<span class="required">*</span></label>
										<div class="controls">
                                            <select class="span6 m-wrap" name="year">
                                                <c:forEach begin="2015" end="${currentYear-1}" step="1" var="yearStop">
                                                    <option value="${yearStop}">${yearStop}</option>
                                                </c:forEach>
                                            </select>
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
