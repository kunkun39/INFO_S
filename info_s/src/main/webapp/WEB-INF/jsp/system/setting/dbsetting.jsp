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
							<li><a href="${pageContext.request.contextPath}/system/dbsetting.html">存储服务器管理</a></li>
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
								<div class="caption"><i class="icon-user"></i>主存储服务器管理</div>
								<div class="actions">
								</div>
							</div>

							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th style="width: 5%">序号</th>
											<th style="width: 25%">服务器地址</th>
											<th style="width: 25%">数据库端口</th>
											<th style="width: 25%">数据库名称</th>
											<th style="width: 20%">操作</th>
										</tr>
									</thead>

									<tbody>
                                        <tr class="odd gradeX">
                                            <td>1</td>
                                            <td>${mainDB.host}</td>
                                            <td>${mainDB.port}</td>
                                            <td>${mainDB.dbName}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/system/dbform.html?dbConfId=${mainDB.id}" class="btn mini green"><i class="icon-edit"></i> 修改</a>
                                            </td>
                                        </tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>
				</div>

                <div class="row-fluid">
					<div class="span12" data-tablet="span12 fix-offset" data-desktop="span6">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption"><i class="icon-user"></i>从存储服务器管理</div>
								<div class="actions">
									<a href="${pageContext.request.contextPath}/system/dbform.html" class="btn blue"><i class="icon-pencil"></i> 新加</a>
								</div>
							</div>

							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th style="width: 5%">序号</th>
											<th style="width: 25%">服务器地址</th>
											<th style="width: 25%">数据库端口</th>
											<th style="width: 25%">数据库名称</th>
											<th style="width: 20%">操作</th>
										</tr>
									</thead>

									<tbody>
                                        <c:forEach items="${dbs}" var="db" varStatus="counter">
                                            <tr class="odd gradeX">
                                                <td>${counter.count}</td>
                                                <td>${db.host}</td>
                                                <td>${db.port}</td>
                                                <td>${db.dbName}</td>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/system/dbform.html?dbConfId=${db.id}" class="btn mini green"><i class="icon-edit"></i> 修改</a>
                                                    <a href="${pageContext.request.contextPath}/system/bakuphistoryoverview.html?dbConfId=${db.id}" class="btn mini yellow"><i class="icon-paper-clip"></i> 备份历史</a>
                                                </td>
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
