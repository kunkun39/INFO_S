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
                                <a href="${pageContext.request.contextPath}/system/dbsetting.jsp">存储服务器管理</a>
                                <i class="icon-angle-right"></i>
                            </li>
							<li><a href="${pageContext.request.contextPath}/system/dbsetting.jsp">服务器备份历史</a></li>
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
								<div class="caption"><i class="icon-user"></i>服务器地址${subDBConf.host}, 服务器端口${subDBConf.port}</div>
								<div class="actions">
									<a href="${pageContext.request.contextPath}/system/bakuphistoryform.html?subDBConfId=${subDBConf.id}" class="btn blue"><i class="icon-pencil"></i> 新加备份</a>
								</div>
							</div>

							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th style="width: 5%">序号</th>
											<th style="width: 20%">备份时间</th>
											<th style="width: 35%">备份项目</th>
											<th style="width: 30%">备份年份</th>
										</tr>
									</thead>

									<tbody>
                                        <c:forEach items="${histories}" var="history" varStatus="counter">
                                            <tr class="odd gradeX">
                                                <td>${counter.count}</td>
                                                <td>${history.host}</td>
                                                <td>${history.year}</td>
                                                <td>${history.projectCode}</td>
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

    <div id="setting_dialog_info" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
        <input type="hidden" id="div_conf_key" value=""/>
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h3 id="myModalLabel3">系统确认对话框</h3>
        </div>

        <div class="modal-body">
            <p>请确认时候要修改系统配置？</p>
        </div>

        <div class="modal-footer">
            <button class="btn blue" data-dismiss="modal">取消</button>
            <button class="btn blue" onclick="changeSystemConf()">确认</button>
        </div>
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
    <script src="${pageContext.request.contextPath}/media/js/ui-general.js"></script>
	<script src="${pageContext.request.contextPath}/media/js/table-managed.js"></script>
    <script src="${pageContext.request.contextPath}/dwr/engine.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/util.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/interface/SystemDWRHandler.js" type="text/javascript"></script>

    <script>
		jQuery(document).ready(function() {
		    App.init(); // initlayout and core plugins
		});

        function confirmChangeSystemConf(confKey) {
            $("#div_conf_key").val(confKey);

            $("#setting_dialog_info").modal("show");
        }

        function changeSystemConf() {
            var confKey = $("#div_conf_key").val();
            var confValue = $("#" + confKey).val();
            SystemDWRHandler.updateSystemConfig(confKey, confValue, function(result) {
                $("#setting_dialog_info").modal("hide");
            });
        }

	</script>
</body>

</html>
