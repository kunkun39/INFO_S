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
                        <%--元数据管理 <small>managed table samples</small>--%>
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
                        <div class="portlet box grey">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-user"></i>元数据</div>
                                <%--<div class="actions">--%>
                                    <%--<a href="${pageContext.request.contextPath}/project/projectform.html" class="btn blue"><i class="icon-plus"></i> 新建项目</a>--%>
                                <%--</div>--%>
                            </div>
                            <div class="portlet-body">
                                <table class="table table-striped table-bordered table-hover" id="sample_2">
                                    <thead>
                                    <tr>
                                        <th style="width:8px;"></th>
                                        <th>元数据名</th>
                                        <th class="hidden-480">所属项目</th>
                                        <th class="hidden-480">所属收集项</th>
                                        <th class="hidden-480">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${metaDatas}" var = "metadata">
                                        <tr class="odd gradeX">
                                            <td><input type="checkbox" class="checkboxes" value="1" /></td>
                                            <td>${metadata.metadataName}</td>
                                            <td class="hidden-480">${metadata.projectName}</td>
                                            <td class="hidden-480">
                                                <c:choose>
                                                    <c:when test="${metadata.used}">${metadata.itemName}</c:when>
                                                    <c:otherwise><font color="grey">none</font></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <a class="btn mini purple" onclick="window.location.href = '${pageContext.request.contextPath}/project/metadatadetails.html?metadataId=${metadata.id}'">
                                                    <i class="icon-cog"></i> 查看
                                                </a>
                                                <a class="btn mini yellow" onclick="window.location.href = '${pageContext.request.contextPath}/project/metadataexport.html?metadataId=${metadata.id}'">
                                                    <i class="icon-print"></i> 导出
                                                </a>
                                                <c:if test="${!metadata.used}">
                                                    <a class="btn mini black" onclick="deleteMatedata(${metadata.id}, '${metadata.metadataName}');">
                                                        <i class="icon-trash"></i> 删除
                                                    </a>
                                                </c:if>
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
    <div id="showMetadataopup" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h3>系统确认对话框</h3>
        </div>
        <div class="modal-body">
            <div class="span6">
                <div class="portlet">
                    <div class="portlet-title line">
                        <div class="caption" style="border: 1px solid red"><i class="icon-comments"></i>Chats</div>
                    </div>
                    <div class="portlet-body" style="border: 1px solid red" id="chats">
                        <div class="scroller" style="width: 200px; "data-height="100px" data-always-visible="1" data-rail-visible1="1">
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                            <div style="border: 1px solid red;width: 100px">测试</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn blue" data-dismiss="modal">取消</button>
            <button class="btn blue" onclick="metadataDeleteConf();">确认</button>
        </div>
    </div>
    <div id="metadataDeletePopup" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
        <form id="metadataDeleteForm" class="form-horizontal" action="${pageContext.request.contextPath}/project/metadatadeleteform.html" method="post">
            <input id="metadataId" name="metadataId" type="hidden" value=""/>
        </form>
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h3 id="myModalLabel3">系统确认对话框</h3>
        </div>

        <div class="modal-body">
            <p id="confMessage"></p>
        </div>

        <div class="modal-footer">
            <button class="btn blue" data-dismiss="modal">取消</button>
            <button class="btn blue" onclick="metadataDeleteConf();">确认</button>
        </div>
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

        function deleteMatedata(metadataId, metadataName) {
            jQuery("#metadataId").val(metadataId);
            jQuery("#confMessage").html("请确认要删除元数据：" + metadataName + " ?");
            jQuery("#metadataDeletePopup").modal();
        }

        function metadataDeleteConf() {
            jQuery("#metadataDeleteForm").submit();
        }

        function showMetadata(metadataId) {
            jQuery("#showMetadataopup").modal();
        }
    </script>
</body>
</html>
