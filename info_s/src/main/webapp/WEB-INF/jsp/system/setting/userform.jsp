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
	<style type="text/css">
		.float-left {
			float: left;
			margin-left: 15px;
		}
	</style>
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
                                            <spring-form:input id="name" path="name" maxlength="30" cssClass="span6 m-wrap float-left" onBlur="checkname()"/>&nbsp;
											<span id="error_info_name" class="help-inline" style="display:none"></span>
										</div>
									</div>

                                    <div class="control-group">
										<label class="control-label">员工编号<span class="required">*</span></label>
										<div class="controls">
                                            <spring-form:input id="username" path="username" maxlength="30" cssClass="span6 m-wrap" onblur="checkUserName()"/>&nbsp;
											<span id="error_info_username" class="help-inline" style="display:none"></span>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">联系方式<span class="required">*</span></label>
										<div class="controls">
											<spring-form:input id="contactway" path="contactWay" maxlength="30" cssClass="span6 m-wrap" onblur="checkContactways()"/>&nbsp;
											<span id="error_info_contactWay" class="help-inline" style="display:none"></span>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">系统角色<span class="required">*</span></label>
										<span id="error_info_roletype" class="help-inline" style="display:none"></span>
										<div class="controls">
											<label class="radio line">
											<input type="radio" id="systemrole" name="membership" value="1" />
											系统管理员
											</label>
											<label class="radio line">
											<input type="radio" id="projectrole" name="membership" value="2" />
											项目管理员
											</label>
										</div>
									</div>

									<div class="form-actions">
                                        <button type="button" id="submituser" class="btn blue" onclick="checkFormInput()">保存</button>
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

    <script type="text/javascript">
       jQuery(document).ready(function() {
		   App.init();
		   FormValidation.init();
		});

	   var nameChecked = false;
	   var usernameState = 1;
	   var contactwayChecked = false;
	   var userRoleChecked = false;

	   function checkFormInput(){
		   var cansubmit=true;
		   if(!nameChecked){
			   jQuery("#error_info_name").css("display", "block");
			   jQuery("#error_info_name").html("<i class=\"ico-error\"></i>用户名不能为空!");
			   cansubmit=false;
		   }else{
			   jQuery("#error_info_name").css("display", "none");
		   }


		   if (usernameState == 1) {//返回1,为空
			   jQuery("#error_info_username").html("<i class=\"ico-error\"></i>用户账号不能为空!");
			   jQuery("#error_info_username").css("display", "block");
			   cansubmit = false;
		   }else if (usernameState == 2) {//返回2格式不对
			   jQuery("#error_info_username").html("<i class=\"ico-error\"></i>账号格式不正确!");
			   jQuery("#error_info_username").css("display", "block");
			   cansubmit = false;
		   } else if (usernameState == 3) {//返回3用户名已存在
			   jQuery("#error_info_username").html("<i class=\"ico-error\"></i>账号已注册!");
			   jQuery("#error_info_username").css("display", "block");
			   cansubmit = false;
		   } else {//返回0 账号可以注册
			   jQuery("#error_info_username").css("display", "none");
		   }

		   if(!contactwayChecked){
			   jQuery("#error_info_contactWay").css("display", "block");
			   jQuery("#error_info_contactWay").html("<i class=\"ico-error\"></i>联系方式不能为空!");
			   cansubmit = false;
		   }else{
			   jQuery("#error_info_contactWay").css("display", "none");
		   }

		   if(!userRoleChecked){
			   jQuery("#error_info_roletype").css("display", "block");
			   jQuery("#error_info_roletype").html("<i class=\"ico-error\"></i>联系方式不能为空!");
			   cansubmit = false;
		   }else{
			   jQuery("#error_info_roletype").css("display", "none");
		   }

		   if(cansubmit){
			   jQuery("#submituser").submit();
		   }
	   }

	   function checkname(){
			var name=jQuery("#name").val();
			if(name==null || name==""){
				jQuery("#error_info_name").css("display", "block");
				jQuery("#error_info_name").html("<i class=\"ico-error\"></i>用户名不能为空!");
				nameChecked = false;
			}else{
				jQuery("#error_info_name").css("display", "none");
				nameChecked = true;
			}
		}

	   function checkUserName(){
		   var username=jQuery("#username").val();
		   if(username==null || username==""){
			   jQuery("#error_info_username").css("display", "block");
			   jQuery("#error_info_username").html("<i class=\"ico-error\"></i>用户账号不能为空!");
			   usernameState = 1;
			   return;
		   }

		   SystemDWRHandler.checkNameInfo(username, function (result) {
			   usernameState = result;
			   if (result == 2) {//返回2格式不对
				   jQuery("#error_info_username").html("<i class=\"ico-error\"></i>账号格式不正确!");
				   jQuery("#error_info_username").css("display", "block");
			   } else if (result == 3) {//返回3用户名已存在
				   jQuery("#error_info_username").html("<i class=\"ico-error\"></i>账号已注册!");
				   jQuery("#error_info_username").css("display", "block");
			   } else {//返回0 账号可以注册
				   jQuery("#error_info_username").css("display", "none");
			   }
		   });
	   }

	   function checkContactways(){
		   var contactway=jQuery("#contactway").val();
		   if(contactway==null || contactway==""){
			   jQuery("#error_info_contactWay").css("display", "block");
			   jQuery("#error_info_contactWay").html("<i class=\"ico-error\"></i>联系方式不能为空!");
			   contactwayChecked = false;
		   }else{
			   jQuery("#error_info_contactWay").css("display", "none");
			   contactwayChecked = true;
		   }
	   }

	   function checkRoleways(){
		   var box = document.getElementsByName("membership");
		   // 循环为每个 radio 绑定 onclick 事件
		   for (var i = 0; i < box.length; i++) {
			   var boxone = box[i];
				if (boxone.checked) {
					userRoleChecked = true;
					jQuery("#error_info_roletype").css("display", "block");
					jQuery("#error_info_roletype").html("<i class=\"ico-error\"></i>请选择用户权限!");
					return;
				}
		   }
		   jQuery("#error_info_roletype").css("display", "none");
		   userRoleChecked = false;
	   }

	</script>
</body>

</html>
