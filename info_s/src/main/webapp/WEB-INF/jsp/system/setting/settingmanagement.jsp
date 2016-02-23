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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/DT_bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/jquery-ui-1.10.1.custom.min.css"/>
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
							<li><a href="${pageContext.request.contextPath}/system/settingmanagement.jsp">系统配置管理</a></li>
						</ul>
					</div>
				</div>
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12" data-tablet="span12 fix-offset" data-desktop="span6">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption"><i class="icon-user"></i>系统配置管理</div>
								<div class="actions">
								</div>
							</div>

							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover" id="sample_2">
									<thead>
										<tr>
											<th style="width: 10%">序号</th>
											<th style="width: 30%">配置说明</th>
											<th style="width: 45%">当前值</th>
											<th style="width: 15%">操作</th>
										</tr>
									</thead>

									<tbody>
                                        <c:forEach items="${confs}" var="conf" varStatus="counter">
                                            <tr class="odd gradeX">
                                                <td>${counter.count}</td>
                                                <td>${conf.confKey.description}</td>
                                                <td><input id="${conf.confKey.name}" value="${conf.confValue}"/></td>
                                                <td><span class="label label-success" onclick="changeSystemConf('${conf.confKey.name}')">修改</span></td>
										    </tr>
                                        </c:forEach>
									</tbody>
								</table>

							</div>
						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->

		</div>
		<!-- END PAGE -->

	</div>

    <div id="setting_dialog_info" title="系统确认对话框" class="hide">
        <p><br/>请确认时候要修改系统配置？</p>
    </div>

	<!-- END CONTAINER -->
    <c:import url="../../common/jspart.jsp"/>
    <!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/select2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/DT_bootstrap.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${pageContext.request.contextPath}/media/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/media/js/table-managed.js"></script>
    <script src="${pageContext.request.contextPath}/dwr/engine.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/util.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/interface/SystemDWRHandler.js" type="text/javascript"></script>

    <script>
		jQuery(document).ready(function() {

		   App.init(); // initlayout and core plugins
		});

        function changeSystemConf(confKey) {
            $("#setting_dialog_info").dialog({
                dialogClass: 'ui-dialog-grey',
                autoOpen: false,
                resizable: false,
                height: 120,
                modal: true,
                buttons: [
                    {
                        'class' : 'btn blue',
                        "text" : "取消",
                        click: function() {
                            $(this).dialog("close");
                        }
                    },
                    {
                        'class' : 'btn green',
                        "text" : "确定",
                        click: function() {
                            var confValue = $("#" + confKey).val();
                            SystemDWRHandler.updateSystemConfig(confKey, confValue, function(result) {
                                $("#setting_dialog_info").dialog("close");
                            });
                        }
                    }
                ]
            });

             $("#setting_dialog_info").dialog("open");
            $('.ui-dialog button').blur();
        }

	</script>
</body>

</html>
