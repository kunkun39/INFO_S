<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                        <br/>
                        <ul class="breadcrumb">
                            <li>
                                <i class="icon-home"></i>
                                <a href="${pageContext.request.contextPath}/system/dashboard.html">首页</a>
                                <i class="icon-angle-right"></i>
                            </li>
                            <li><a href="javascript:;">项目编辑</a></li>
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
                                <div class="caption"><i class="icon-reorder"></i>项目信息</div>
                            </div>

                            <div class="portlet-body form">
                                <!-- BEGIN FORM-->
                                <spring-form:form commandName="project" id="form_sample_2" class="form-horizontal" method="post">
                                    <div class="alert alert-error hide">
                                        <button class="close" data-dismiss="alert"></button>
                                        You have some form errors. Please check below.
                                    </div>

                                    <div class="alert alert-success hide">
                                        <button class="close" data-dismiss="alert"></button>
                                        Your form validation is successful!
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">项目名<span class="required">*</span></label>
                                        <div class="controls">
                                            <spring-form:input path="projectName" maxlength="30" cssClass="span6 m-wrap"/>&nbsp;
                                            <span class="help-inline">
                                                <spring-form:errors path="projectName"/>
                                            </span>
                                        </div>
                                    </div>
                                    <c:if test="${showItem}">
                                        <div class="control-group">
                                            <label class="control-label">收集项<span class="required">*</span></label>
                                            <div class="controls">
                                                <!-- BEGIN PAGE CONTENT-->
                                                <div class="row-fluid">
                                                    <div class="span12" data-tablet="span12 fix-offset" data-desktop="span6">
                                                        <div class="portlet-body">
                                                            <input name="appStatus" type="hidden" value="111"/>
                                                            <table class="table table-striped table-bordered table-hover" id="sample_2">
                                                                <thead>
                                                                <tr>
                                                                    <th style="width:8px;"></th>
                                                                    <th>收集项名字</th>
                                                                    <th class="hidden-480">键值</th>
                                                                    <th class="hidden-480">格式</th>
                                                                    <th class="hidden-480">操作</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <c:forEach items="${items}" var = "item">
                                                                    <tr class="odd gradeX">
                                                                        <td><input type="checkbox" class="checkboxes" value="1" /></td>
                                                                        <td>${item.itemName}</td>
                                                                        <td class="hidden-480">${item.itemKey}</td>
                                                                        <td class="hidden-480">2016/01/01 00:00</td>
                                                                        <td>
                                                                            <a class="btn mini purple" onclick="itemInfo.itemId=${item.id};itemInfo.itemName='${item.itemName}';itemInfo.itemKey='${item.itemKey}';itemInfo.metadataId=${item.metaDataId};showItemInfo();">
                                                                                <i class="icon-edit"></i> 编辑
                                                                            </a>
                                                                            <a class="btn mini black" href="#">
                                                                                <i class="icon-trash"></i> 删除
                                                                            </a>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <tr class="odd gradeX">
                                                                    <td><input type="checkbox" class="checkboxes" value="1" /></td>
                                                                    <td>开机时间</td>
                                                                    <td class="hidden-480">boottime</td>
                                                                    <td class="hidden-480">2016/01/01 00:00</td>
                                                                    <td>
                                                                        <a class="btn mini purple" href="#">
                                                                            <i class="icon-edit"></i> 编辑
                                                                        </a>
                                                                        <a class="btn mini black" href="#">
                                                                            <i class="icon-trash"></i> 删除
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                            <a class="btn mini blue" href="#" onclick="addItemInfo();">
                                                                <i class="icon-plus"></i> 新加
                                                            </a>
                                                        </div>
                                                        <!-- END EXAMPLE TABLE PORTLET-->
                                                    </div>
                                                </div>
                                                <!-- END PAGE CONTENT-->
                                            </div>
                                        </div>
                                    </c:if>
                                    <div class="form-actions">
                                        <button type="button" class="btn yellow" onclick="window.location.href = '${pageContext.request.contextPath}/project/projectoverview.html'">返回</button>
                                        <button type="submit" class="btn blue" onclick="projectInfoSubmit(this.form);">保存</button>
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

    <div id="itemInfoPopup" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h3 id="myModalLabel1">编辑收集项信息</h3>
        </div>
        <div class="modal-body">
            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN VALIDATION STATES-->
                    <div class="portlet box green">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>收集项</div>
                        </div>

                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form id="itemForm" class="form-horizontal" action="${pageContext.request.contextPath}/project/itemform.html" method="post" enctype="multipart/form-data">
                                <input name="projectId" type="hidden" value="${project.id}"/>
                                <input name="itemId" type="hidden" value=""/>
                                <div class="control-group">
                                    <div class="control-group">
                                        <label class="control-label">收集项名字<span class="required">*</span></label>
                                        <div class="controls">
                                            <input id="itemName" type="text" name="name" placeholder="" class="m-wrap" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">键值<span class="required">*</span></label>
                                        <div class="controls">
                                            <input id="itemKey" type="text" name="key" placeholder="" class="m-wrap" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">使用元数据<span class="required">*</span></label>
                                        <div class="controls">
                                            <select name="usemetadata" class="medium m-wrap" tabindex="1">
                                                <option id="selectFalse" value="false">否</option>
                                                <option id="selectTrue" value="true">是</option>
                                            </select>

                                        </div>
                                        <%--<div class="controls">--%>
                                            <%--<label id="usemetadata" class="checkbox">--%>
                                                <%--<input type="checkbox" name="usemetadata" value="true"/>--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                    </div>
                                    <div id="uploadfile" class="control-group">
                                        <label class="control-label">元数据文件<span class="required">*</span></label>
                                        <div class="controls">
                                            <input class="default" name="metadataUploadFile" type="file">
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                    <!-- END VALIDATION STATES-->

                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">返回</button>
            <button class="btn yellow" onclick="itemFormSubmit();">提交</button>
        </div>
    </div>
    <!-- END CONTAINER -->
    <c:import url="../common/jspart.jsp"/>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <script src="${pageContext.request.contextPath}/media/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/media/js/form-validation.js"></script>
    <script src="${pageContext.request.contextPath}/media/js/form-components.js"></script>
    <!-- END PAGE LEVEL STYLES -->
    <script type="text/javascript">
        jQuery(document).ready(function() {
            App.init();
        });

        var itemInfo = {
            itemId : -1 ,
            itemName : '',
            itemKey : '',
            metadataId : -1
        };

        function projectInfoSubmit(form) {
            form.submit();
        }

        function showItemInfo() {
            jQuery("#itemName").val(itemInfo.itemName);
            jQuery("#itemKey").val(itemInfo.itemKey);
            jQuery("#itemId").val(itemInfo.itemId);
            if (itemInfo.metadataId != -1) {
                jQuery("#selectTrue").attr("selected","selected");
            } else {
                jQuery("#selectTrue").removeAttr("selected");;
            }
            jQuery("#itemInfoPopup").modal();
        }

        function addItemInfo() {
            jQuery("#itemName").val('');
            jQuery("#itemKey").val('');
            jQuery("#itemId").val(-1);
            jQuery("#selectTrue").removeAttr("selected");
            jQuery("#itemInfoPopup").modal();
        }

        function itemFormSubmit() {
            jQuery("#itemForm").submit();
        }
    </script>
</body>
</html>
