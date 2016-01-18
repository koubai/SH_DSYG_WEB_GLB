<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<title>东升盈港-修改密码</title>
<script type="text/javascript">
function goHome() {
	window.location.href = '<c:url value="/managehome/showManageHomeAction.action"></c:url>';
}

function upd() {
	var oldpassword = $("#oldpassword").val().trim();
	var password = $("#password").val().trim();
	var repassword = $("#repassword").val().trim();
	if(oldpassword == "") {
		alert("请输入旧密码！");
		$("#oldpassword").focus();
		return;
	}
	if(password == "") {
		alert("请输入新密码！");
		$("#password").focus();
		return;
	}
	if(password.length < 4) {
		alert("密码不能少于4位！");
		$("#password").focus();
		return;
	}
	if(repassword == "") {
		alert("确认密码不能为空！");
		$("#repassword").focus();
		return;
	}
	if(password != repassword) {
		alert("两次密码不一致！");
		$("#password").focus();
		return;
	}
	if(confirm("确定修改吗？")) {
		document.mainform.action = '<c:url value="/user/updPasswordAction.action"></c:url>';
		document.mainform.submit();
	}
}
</script>
</head>
<body>
<div id="container">
	<div class="header clearfix">
		<div class="logo cf">
			<h1>修改密码</h1>
		</div>
	</div>
	<div class="content clearfix">
		<div class="form-wrapper">
			<s:form id="mainform" name="mainform" method="POST">
				<div style="position:absolute; margin-left: 150px; margin-top: -50px; text-align: center; color: red;">
					<s:actionmessage />
				</div>
				<div class="form-item">
					<label class="form-label" for="userName">旧登录密码</label>
					<div class="form-field">
						<input type="password" placeholder="请输入旧登录密码" class="form-text" name="psdUserDto.oldpassword" id="oldpassword" value="">
					</div>
				</div>
				<div class="form-item">
                   	<label class="form-label" for="password">新登录密码</label>
                   	<div class="form-field">
                   		<input type="password" placeholder="请输入新登录密码" class="form-text" name="psdUserDto.password" id="password">
                   	</div>
                   </div>
				<div id="mobile_vcode_item" class="form-item" style="display: block;">
					<label class="form-label" for="mobileVcode">确认新密码</label>
					<div class="form-field">
						<input type="password" placeholder="确认新密码" class="form-text" name="psdUserDto.repassword" id="repassword">
					</div>
				</div>
					<div class="form-action">
					<button type="button" id="register_btn" class="btn btn-blue" onclick="upd();">修改</button>
					<button type="button" id="register_btn" class="btn btn-gray" onclick="goHome();">返回</button>
				</div>
			</s:form>
		</div>
	</div>
</div>
</body>
</html>
