<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>

<div class="page-sidebar nav-collapse collapse">
    <!-- BEGIN SIDEBAR MENU -->
    <ul class="page-sidebar-menu">
        <li>
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            <div class="sidebar-toggler hidden-phone"></div>
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
        </li>

        <li>
            <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
            <form class="sidebar-search">
                <div class="input-box">
                    <a href="javascript:;" class="remove"></a>
                    <input type="text" placeholder="Search..." />
                    <input type="button" class="submit" value=" " />
                </div>
            </form>
            <!-- END RESPONSIVE QUICK SEARCH FORM -->
        </li>

        <li class="start">
            <a class="ajaxify start" href="javascript:;">
                <i class="icon-home"></i>
                <span class="title">首页</span>
            </a>
        </li>

        <li <c:if test="${MENU_KEY=='SYS_SETTING'}">class="active"</c:if>>
            <a href="javascript:;">
                <i class="icon-cogs"></i>
                <span class="title">系统设置</span>
                <span class="arrow"></span>
            </a>

            <ul class="sub-menu">
                <li <c:if test="${SUB_MENU_KEY=='SETTING_USER'}">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath}/system/usermanagement.html">系统用户管理</a>
                </li>

                <li <c:if test="${SUB_MENU_KEY=='SETTING_CONF'}">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath}/system/settingmanagement.html">系统配置管理</a>
                </li>
            </ul>
        </li>
    </ul>
    <!-- END SIDEBAR MENU -->
</div>