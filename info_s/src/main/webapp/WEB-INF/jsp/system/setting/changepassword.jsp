<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8"/>
    <c:import url="../../common/csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/chosen.css"/>
    <style type="text/css">
        .float-left {
            float: left;
            margin-left: 15px;
        }

        .input {
            width: 200px;
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
                        <li><a href="javascript:;">密码修改</a></li>
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
                            <div class="caption"><i class="icon-reorder"></i>密码修改</div>
                        </div>

                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <spring-form:form commandName="user" id="form_changepassword" method="post" class="form-horizontal">
                                <input type="hidden" name="id" value="${user.id}"/>
                                <%--<spring-form:input id="id" path="id" style="display:none"/>--%>

                                <div class="alert alert-error hide">
                                    <button class="close" data-dismiss="alert"></button>
                                    You have some form errors. Please check below.
                                </div>

                                <div class="alert alert-success hide">
                                    <button class="close" data-dismiss="alert"></button>
                                    Your form validation is successful!
                                </div>

                                <div class="control-group">
                                    <label class="control-label">员工编号<span class="required">*</span></label>

                                    <div class="controls">
                                        <spring-form:input id="username" path="username" class="input" maxlength="30" readonly="true"/>&nbsp;
                                        <span id="error_info_username" class="help-inline" style="display:none"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label">旧密码<span class="required">*</span></label>

                                    <div class="controls">
                                        <input id="oldpassword" type="password" class="input" maxlength="30" onblur="checkOldPassword()"/>&nbsp;
                                        <span id="error_info_oldpassword" class="help-inline" style="display:none"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label">新密码<span class="required">*</span></label>

                                    <div class="controls">
                                        <spring-form:input id="password" type="password" class="input" maxlength="30" path="password" onblur="checkNewPassword()"/>&nbsp;
                                        <span id="error_info_password" class="help-inline" style="display:none"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">确认密码<span class="required">*</span></label>

                                    <div class="controls">
                                        <input id="passwordagain" maxlength="30" class="input" type="password" onblur="checkNewPasswordAgain()"/>&nbsp;
                                        <span id="error_info_newpassword2" class="help-inline" style="display:none"></span>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <button type="button" id="submituser" class="btn blue" onclick="checkFormInput()">确认修改</button>
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
<script src="${pageContext.request.contextPath}/dwr/engine.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/dwr/interface/SystemDWRHandler.js" type="text/javascript"></script>
<!-- END PAGE LEVEL STYLES -->

<script type="text/javascript">
    jQuery(document).ready(function () {
        App.init();
        FormValidation.init();

    });

    var oldpasswordState = 1;
    var newpasswordChecked = false;
    var passworkAgainChecked = false;

    function checkFormInput() {
        var cansubmit = true;

        checkOldPassword();
        checkNewPassword();
        checkNewPasswordAgain();

        if (oldpasswordState == 1) {
            jQuery("#error_info_oldpassword").html("<i class=\"ico-error\"></i>请正确输入旧密码!");
            jQuery("#error_info_oldpassword").css("display", "block");
            cansubmit = false;
        } else if (oldpasswordState == 2) {
            jQuery("#error_info_oldpassword").html("<i class=\"ico-error\"></i>当前登录账号信息异常，请重新登录!");
            jQuery("#error_info_oldpassword").css("display", "block");
            cansubmit = false;
        } else if (oldpasswordState == 3) {
            jQuery("#error_info_oldpassword").html("<i class=\"ico-error\"></i>密码不正确");
            jQuery("#error_info_oldpassword").css("display", "block");
            cansubmit = false;
        } else {//返回0 密码输入正确
            jQuery("#error_info_oldpassword").css("display", "none");
        }

        if (!newpasswordChecked) {
            jQuery("#error_info_password").css("display", "block");
            jQuery("#error_info_password").html("<i class=\"ico-error\"></i>用户密码不能为空!");
            cansubmit = false;
        } else {
            jQuery("#error_info_password").css("display", "none");
        }

        if (!passworkAgainChecked) {
            jQuery("#error_info_newpassword2").css("display", "block");
            jQuery("#error_info_newpassword2").html("<i class=\"ico-error\"></i>确认密码和新密码不一致");
            cansubmit = false;
        } else {
            jQuery("#error_info_newpassword2").css("display", "none");
        }


        if (cansubmit) {
            jQuery("#form_changepassword").submit();
        }
    }


    function checkOldPassword() {
        var oldpassword = jQuery("#oldpassword").val();
        if (oldpassword == null || oldpassword == "") {
            jQuery("#error_info_oldpassword").css("display", "block");
            jQuery("#error_info_oldpassword").html("<i class=\"ico-error\"></i>请输入正确的旧密码!");
            oldpasswordState = 1;
            return;
        }

        SystemDWRHandler.checkUserPassword(oldpassword, function (result) {
            oldpasswordState = result;//0密码输入正确  1：密码为空 ； 2：登陆用户信息获取异常 3：密码不正确
            if (result == 2) {
                jQuery("#error_info_oldpassword").html("<i class=\"ico-error\"></i>当前登录账号信息异常，请重新登录!");
                jQuery("#error_info_oldpassword").css("display", "block");
            } else if (result == 3) {
                jQuery("#error_info_oldpassword").html("<i class=\"ico-error\"></i>密码不正确");
                jQuery("#error_info_oldpassword").css("display", "block");
            } else {//返回0 密码输入正确
                jQuery("#error_info_oldpassword").css("display", "none");
            }
        });
    }


    function checkNewPassword() {
        var password = jQuery("#password").val();
        if (password == null || password == "") {
            jQuery("#error_info_password").css("display", "block");
            jQuery("#error_info_password").html("<i class=\"ico-error\"></i>用户密码不能为空!");
            newpasswordChecked = false;
        } else {
            jQuery("#error_info_password").css("display", "none");
            newpasswordChecked = true;
        }
    }

    function checkNewPasswordAgain() {
        var password = jQuery("#password").val();
        var passwordAgain = jQuery("#passwordagain").val();

        if (passwordAgain == null || passwordAgain == "" || passwordAgain != password) {
            jQuery("#error_info_newpassword2").css("display", "block");
            jQuery("#error_info_newpassword2").html("<i class=\"ico-error\"></i>确认密码和新密码不一致");
            passworkAgainChecked = false;
        } else {
            jQuery("#error_info_newpassword2").css("display", "none");
            passworkAgainChecked = true;
        }

    }

</script>
</body>

</html>
