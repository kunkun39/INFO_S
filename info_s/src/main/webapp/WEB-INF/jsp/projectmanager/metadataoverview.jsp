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
                                                <a class="btn mini purple" onclick="metadataDetails(${metadata.id})">
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

    <script src="${pageContext.request.contextPath}/media/js/popup/modal.popup.js" type="text/javascript"></script>
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

        jQuery(function() {
            settings = {
                align : 'center',									//Valid values, left, right, center
                top : 50, 											//Use an integer (in pixels)
                width : 600, 										//Use an integer (in pixels)
                height : 500, 										//Use an integer (in pixels)
                padding : 10,										//Use an integer (in pixels)
                backgroundColor : 'white', 						    //Use any hex code
                source : '', 				    					//Refer to any page on your server, external pages are not valid e.g. http://www.google.co.uk
                borderColor : '#333333', 							//Use any hex code
                borderWeight : 4,									//Use an integer (in pixels)
                borderRadius : 5, 									//Use an integer (in pixels)
                fadeOutTime : 300, 									//Use any integer, 0 : no fade
                disableColor : '#666666', 							//Use any hex code
                disableOpacity : 40, 								//Valid range 0-100
                loadingImage : '${pageContext.request.contextPath}/media/js/popup/loading.gif'
            };
            jQuery(document).keyup(function(event) {
                if (event.keyCode == 27) {
                    closePopup(settings.fadeOutTime);
                }
            });
        });

        function metadataDetails(id) {
            settings.source = '${pageContext.request.contextPath}/project/metadatadetails.html?metadataId=' + id;
            openModalPopup(settings);
        }

        function openModalPopup(obj) {
            modalPopup(obj.align, obj.top, obj.width, obj.padding, obj.disableColor, obj.disableOpacity, obj.backgroundColor, obj.borderColor, obj.borderWeight, obj.borderRadius, obj.fadeOutTime, obj.source, obj.loadingImage);
        }
    </script>
</body>
</html>
