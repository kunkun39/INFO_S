<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8" />
    <c:import url="../common/csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/chosen.css" />
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
                        <%--元数据 <small>managed table samples</small>--%>
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
                                <a href="${pageContext.request.contextPath}/project/metadataoverview.html">元数据管理</a>
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
                        <div class="portlet box green">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-user"></i>${metadata.metadataName}</div>
                                <%--<div class="actions">--%>
                                <%--<a href="${pageContext.request.contextPath}/project/projectform.html" class="btn blue"><i class="icon-plus"></i> 新建项目</a>--%>
                                <%--</div>--%>
                            </div>
                            <div class="portlet-body">
                                <table class="table table-striped table-bordered table-hover" id="sample_2">
                                    <thead>
                                    <tr>
                                        <th style="width:8px;"></th>
                                        <th>键</th>
                                        <th class="hidden-480">值</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${metadata.items}" var = "item">
                                        <tr class="odd gradeX">
                                            <td><input type="checkbox" class="checkboxes" value="1" /></td>
                                            <td>${item.index}</td>
                                            <td class="hidden-480">${item.value}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="portlet-body form">
                                <div class="form-actions">
                                    <button type="button" class="btn yellow" onclick="window.location.href = '${pageContext.request.contextPath}/project/metadataoverview.html'">返回</button>
                                </div>
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

</body>
</html>
