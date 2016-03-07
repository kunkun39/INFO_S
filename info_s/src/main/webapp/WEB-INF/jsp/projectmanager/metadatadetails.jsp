<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body class="page-header-fixed">
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
            <div class="portlet-body" style="max-height: 500px; overflow-y:scroll;">
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

        </div>
        <!-- END EXAMPLE TABLE PORTLET-->
    </div>
</div>
</body>
</html>
