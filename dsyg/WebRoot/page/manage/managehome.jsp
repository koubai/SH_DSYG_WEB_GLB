<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<title>东升盈港-后台管理菜单</title>
<script type="text/javascript">
function logout() {
	if(confirm("确定退出吗？")) {
		window.location.href = '<c:url value="/manage/manageLogoutAction.action"></c:url>';
	}
}
</script>
</head>
<body>
<div id="main" style="margin-top:2px;">
	<div  class="header_bg">
		<div class="content">
			<div class="user_bg">
				<div class="user">
					<div class="user_tittle">后台管理菜单
					</div>
				</div>
			</div>
			<div class="user_info">
				<span>用户名：<%=session.getAttribute("user_name")%></span>
				<span>登录时间：<%=session.getAttribute("login_time")%></span>
				<a class="lgout fr" href="javascript:void(0);" onclick="logout();">退出</a>			
			</div>
			<div class="main_body">
				<table class="menu_tab" border="0" cellspacing="0" cellpadding="20">
					<tr>
						<td>
							<a href="<c:url value="/product/showManageProductListAction.action"></c:url>">产品管理</a>
						</td>
						<td>
							<a href="<c:url value="/news/showNewsManageAction.action"></c:url>">新闻管理</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="<c:url value="/case/showCaseAction.action"></c:url>">案例介绍一览</a>
						</td>
						<td>
							<a href="<c:url value="/recruit/showRecruitAction.action"></c:url>">招聘信息一览</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="<c:url value="/qa/showQaAction.action"></c:url>">咨询信息Q/A一览</a>
						</td>
						<td>
							<a href="<c:url value="/user/showUpdPasswordAction.action"></c:url>">密码修改</a>
						</td>
					</tr>
					<tr>
						<td>
							<s:if test='#session.user_rank >= 90'>
								<a href="<c:url value="/user/showUserManagePageAction.action"></c:url>">用户管理</a>
							</s:if>
						</td>
						<td>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
