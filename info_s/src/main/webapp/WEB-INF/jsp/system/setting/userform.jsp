<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
								<a href="index.html">Home</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="userform.jsp#">Managed Tables</a></li>
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
								<div class="caption"><i class="icon-reorder"></i>Advance Validation</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="userform.jsp#portlet-config" data-toggle="modal" class="config"></a>
									<a href="javascript:;" class="reload"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>

							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form action="userform.jsp#" id="form_sample_2" class="form-horizontal">
									<div class="alert alert-error hide">
										<button class="close" data-dismiss="alert"></button>
										You have some form errors. Please check below.
									</div>

									<div class="alert alert-success hide">
										<button class="close" data-dismiss="alert"></button>
										Your form validation is successful!
									</div>

									<div class="control-group">
										<label class="control-label">Name<span class="required">*</span></label>
										<div class="controls">
											<input type="text" name="name" data-required="1" class="span6 m-wrap"/>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Email<span class="required">*</span></label>
										<div class="controls">
											<input name="email" type="text" class="span6 m-wrap"/>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Occupation&nbsp;&nbsp;</label>
										<div class="controls">
											<input name="occupation" type="text" class="span6 m-wrap"/>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Category<span class="required">*</span></label>
										<div class="controls">
											<select class="span6 m-wrap" name="category">
												<option value="">Select...</option>
												<option value="Category 1">Category 1</option>
												<option value="Category 2">Category 2</option>
												<option value="Category 3">Category 5</option>
												<option value="Category 4">Category 4</option>
											</select>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Chosen Dropdown<span class="required">*</span></label>
										<div class="controls chzn-controls">
											<select id="form_2_chosen" class="span6 chosen" data-with-diselect="1" name="options1" data-placeholder="Choose an Option" tabindex="1">
												<option value=""></option>
												<option value="Option 1">Option 1</option>
												<option value="Option 2">Option 2</option>
												<option value="Option 3">Option 3</option>
												<option value="Option 4">Option 4</option>
											</select>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Select2 Dropdown<span class="required">*</span></label>
										<div class="controls select2-wrapper">
											<select id="form_2_select2" class="span6" name="options2">
												<option value=""></option>
												<option value="Option 1">Option 1</option>
												<option value="Option 2">Option 2</option>
												<option value="Option 3">Option 3</option>
												<option value="Option 4">Option 4</option>
											</select>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Membership<span class="required">*</span></label>
										<div class="controls">
											<label class="radio line">
											<input type="radio" name="membership" value="1" />
											Fee
											</label>
											<label class="radio line">
											<input type="radio" name="membership" value="2" />
											Professional
											</label>
											<div id="form_2_membership_error"></div>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Services<span class="required">*</span></label>
										<div class="controls">
											<label class="checkbox line">
											<input type="checkbox" value="1" name="service"/> Service 1
											</label>
											<label class="checkbox line">
											<input type="checkbox" value="2" name="service"/> Service 2
											</label>
											<label class="checkbox line">
											<input type="checkbox" value="3" name="service"/> Service 3
											</label>
											<span class="help-block">(select at least two)</span>
											<div id="form_2_service_error"></div>
										</div>
									</div>

									<div class="form-actions">
										<button type="submit" class="btn green">Validate</button>
										<button type="button" class="btn">Cancel</button>
									</div>
								</form>
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
