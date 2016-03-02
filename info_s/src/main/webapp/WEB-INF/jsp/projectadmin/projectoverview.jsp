<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
    <title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8" />
    <c:import url="../common/csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/DT_bootstrap.css" />
</head>
<body class="page-header-fixed">
    <c:import url="../common/header.jsp"/>

    <!-- BEGIN CONTAINER -->
    <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <c:import url="projectadminmenu.jsp"/>
        <!-- END SIDEBAR -->

        <!-- BEGIN PAGE -->
        <div class="page-content">
            <!-- BEGIN PAGE CONTAINER-->
            <div class="container-fluid">
                <!-- BEGIN PAGE HEADER-->
                <div class="row-fluid">
                    <div class="span12">
                        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                        <br/>
                        <%--<h3 class="page-title">--%>
                            <%--项目管理 <small>managed table samples</small>--%>
                        <%--</h3>--%>
                        <ul class="breadcrumb">
                            <li>
                                <i class="icon-home"></i>
                                <a href="index.html">Home</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li>
                                <a href="#">信息收集</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/project/projectoverview.html">项目管理</a>
                            </li>
                        </ul>
                        <!-- END PAGE TITLE & BREADCRUMB-->
                    </div>
                </div>
                <!-- END PAGE HEADER-->

                <!-- BEGIN PAGE CONTENT-->
                <div class="row-fluid">
                    <div class="span12" data-tablet="span12 fix-offset" data-desktop="span6">
                        <!-- BEGIN EXAMPLE TABLE PORTLET-->
                        <div class="portlet box grey">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-user"></i>项目列表</div>
                                <div class="actions">
                                    <a href="${pageContext.request.contextPath}/project/projectform.html" class="btn blue"><i class="icon-plus"></i> 新建项目</a>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <table class="table table-striped table-bordered table-hover" id="sample_2">
                                    <thead>
                                        <tr>
                                            <th style="width:8px;"></th>
                                            <th>项目名</th>
                                            <th class="hidden-480">创建时间</th>
                                            <th class="hidden-480">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${projects}" var = "project">
                                            <tr class="odd gradeX">
                                                <td><input type="checkbox" class="checkboxes" value="1" /></td>
                                                <td>${project.projectName}</td>
                                                <td class="hidden-480">2016.02.17</td>
                                                <td>
                                                    <a class="btn mini purple" onclick="window.location.href = '${pageContext.request.contextPath}/project/projectform.html?projectId=${project.id}'">
                                                        <i class="icon-edit"></i> 编辑
                                                    </a>
                                                    <a class="btn mini black" href="#">
                                                        <i class="icon-trash"></i> 删除
                                                    </a>
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
    <!-- END CONTAINER -->
    <c:import url="../common/jspart.jsp"/>
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/js/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/js/DT_bootstrap.js"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="${pageContext.request.contextPath}/media/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/media/js/table-managed.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            App.init();
        });

    </script>
</body>
</html>
