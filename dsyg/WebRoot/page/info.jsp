<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript">
	function manageLogout() {
		window.location.href = '<c:url value="/manage/manageLogoutAction.action"></c:url>';
	}
	
	function goManageHome() {
		window.location.href = '<c:url value="/manage/manageLoginAction.action"></c:url>';
	}
</script>
<div class="user"><span>用户：<%=session.getAttribute("user_name")%></span><span>登录时间：<%=session.getAttribute("login_time")%></span></div>