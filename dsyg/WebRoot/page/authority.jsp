<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<title>东升盈港-没有权限</title>
<script type="text/javascript">
</script>
</head>
<body bgcolor="#ffffff">
<div id="main" style="margin-top:2px;">
	<div  class="header_bg">
		<div class="content">
			<div class="user_bg">
				<div class="user">
					<div class="user_tittle">后台管理
					</div>
				</div>
			</div>
			<jsp:include page="../head_manage.jsp" flush="true" />
			<div class="main_body">
				<div class="error">
					<img src="<%=request.getContextPath()%>/images/error.png" />
					<p style="padding-top:20px;"><span class="gray">ERROR</span><span class="red">错误</span></p>
					<p>您没有权限访问！<a class="return1" href="./managehome.shtml">返回</a></p>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>