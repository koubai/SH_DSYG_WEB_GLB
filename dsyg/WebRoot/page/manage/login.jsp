<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<title>东升盈港-后台登录</title>
<script type="text/javascript">
	function login() {
		document.mainform.action = '<c:url value="/manage/manageLoginAction.action"></c:url>';
		document.mainform.submit();
	}
	
	/**
	 * 获取验证码
	 * @param obj
	 * @return
	 */
	function changeValidateCode(obj) {
		//获取当前的时间作为参数，无具体意义
	    var timenow = new Date().getTime();
	    //每次请求需要一个不同的参数，否则可能会返回同样的验证码
	    //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
	    obj.src='<c:url value="/index/rand.action" />?d='+timenow;
	    return false;
	}

	/**
	 * 获取验证码
	 * @param obj
	 * @return
	 */
	function changeValidate(id) {
		var timenow = new Date().getTime();
		if(document.getElementById(id) != null) {
			document.getElementById(id).src='<c:url value="/index/rand.action" />?d='+timenow;
		}
	}
</script>
</head>
<body>
<div id="container">
	<div class="header clearfix">
		<div class="logo cf">
			<h1>后台登录</h1>
		</div>
	</div>
	<div class="content clearfix">
		<div class="form-wrapper">
			<s:form id="mainform" name="mainform" method="POST">
				<div class="form-item">
					<div style="position:absolute; margin-left: 0px; margin-top: -45px; text-align: center; color: red; font-size: 12px;">
						<s:actionmessage />
					</div>
					<label class="form-label" for="userName">用户名</label>
					<div class="form-field">
						<input type="text" placeholder="请输入用户名" class="form-text" maxlength="16" name="userDto.userid" id="userid" value="<s:property value="userDto.userid"/>">
					</div>
				</div>
				<div class="form-item">
                   	<label class="form-label" for="password">密码</label>
                   	<div class="form-field">
                   		<input type="password" placeholder="请输入密码" class="form-text" maxlength="16" name="userDto.password" id="password">
                   	</div>
                   </div>
				<div id="mobile_vcode_item" class="form-item" style="display: block;">
					<label class="form-label" for="mobileVcode">验证码</label>
					<div class="form-field">
						<div class="mobile-vcode-text">
							<input type="text" class="form-text" name="userDto.verificationcode" id="verificationcode" maxlength="4" value="<s:property value="userDto.verificationcode"/>">
							<a id="get_mobile_vcode" class="get-mobile-vcode" href="javascript:void(0);"><img title="看不清点我" id="randomImg" name="random" src="<c:url value="/index/rand.action" />" onclick="changeValidateCode(this)" /></a>
						</div>
					</div>
				</div>
				<div class="form-action">
					<button type="submit" id="register_btn" class="register-btn btn btn-blue" onclick="login();">登录</button>
				</div>
			</s:form>
		</div>
	</div>
</div>
</body>
</html>
