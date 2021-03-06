<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>
<!DOCTYPE html>
<html>
<head>
    <title>长虹网络公司 | 信息收集云平台</title>
    <meta charset="UTF-8"/>
    <c:import url="../../common/csspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/DT_bootstrap.css"/>
    <style type="text/css">
        .enableuser {
            padding: 5px;
            color: red;
        }

        .disableuser {
            padding: 5px;
            color: blue;
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
                            <a href="index.html">Home</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li><a href="#">Managed Tables</a></li>
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
                            <div class="caption"><i class="icon-user"></i>Table</div>
                            <div class="actions">
                                <a href="${pageContext.request.contextPath}/system/userform.html" class="btn blue"><i class="icon-pencil"></i> 新加</a>
                            </div>
                        </div>

                        <div class="portlet-body">
                            <table class="table table-striped table-bordered table-hover" id="sample_2">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>用户名</th>
                                    <th class="hidden-480">账号</th>
                                    <th class="hidden-480">联系方式</th>
                                    <th class="hidden-480">状态</th>
                                    <th class="hidden-480">操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${users}" var="user" varStatus="status">
                                    <tr class="odd gradeX">
                                        <%--<td>${status.index + 1}</td>--%>
                                        <td>${user.id}</td>
                                        <td>${user.name}</td>
                                        <td class="hidden-480">${user.username}</td>
                                        <td class="hidden-480">${user.contactWay}</td>
                                        <c:choose>
                                            <c:when test="${user.enabled}">
                                                <td><span class="disableuser">用户正常</span></td>
                                                <td><a class="btn mini purple"
                                                       onclick="window.location.href = '${pageContext.request.contextPath}/system/userdisable.html?nowenabled=${user.enabled}&current=${paging.currentPageNumber}&userid=${user.id}'">
                                                    <i class="icon-edit"></i> 禁用账户</a>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="enableuser">已被禁用</span></td>
                                                <td><a class="btn mini black"
                                                       onclick="window.location.href='${pageContext.request.contextPath}/system/userdisable.html?nowenabled=${user.enabled}&current=${paging.currentPageNumber}&userid=${user.id}'">
                                                    <i class="icon-trash"></i> 授权使用</a>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="pagination" style="text-align: center;">
                                <ul style="box-shadow: 0px 0px 0px;">
                                    <ch:numberpaging urlMapping="${pageContext.request.contextPath}/system/usermanagement.html" paging="${paging}" maxPageNumber="7"/>
                                </ul>
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

<script>
    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins

        Index.init();

        Index.initJQVMAP(); // init index page's custom scripts

        Index.initCalendar(); // init index page's custom scripts

        Index.initCharts(); // init index page's custom scripts

        Index.initChat();

        Index.initMiniCharts();

        Index.initDashboardDaterange();

        Index.initIntro();

    });

</script>
</body>

</html>
