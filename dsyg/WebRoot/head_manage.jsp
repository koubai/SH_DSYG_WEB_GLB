<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript">
function goHome() {
	window.location.href = '<c:url value="/managehome/showManageHomeAction.action"></c:url>';
}

function logout() {
	if(confirm("确定退出吗？")) {
		window.location.href = '<c:url value="/manage/manageLogoutAction.action"></c:url>';
	}
}
</script>
<div class="user_info">
	<span>用户名：<%=session.getAttribute("user_name")%></span>
	<span>登录时间：<%=session.getAttribute("login_time")%></span>
	<a class="lgout fr mgl5" href="javascript:void(0);" onclick="logout();">退出</a>
	<a class="return1 fr" href="<c:url value="/managehome/showManageHomeAction.action"></c:url>">返回首页</a>
</div>