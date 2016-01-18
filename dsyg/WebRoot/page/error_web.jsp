<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css<s:if test='#session.language == "en"'>/style_en.css</s:if><s:else>/style.css</s:else>" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<title><s:text name="dsyg"/>-<s:text name="errortitle"/></title>
<script type="text/javascript">
</script>
</head>
<body bgcolor="#ffffff">
<jsp:include page="./head_web.jsp" flush="true" />
<div id="main">
	<div class="content">
		<div class="error">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>error.png" />
			<p style="padding-top:40px;"><span class="gray">ERROR</span><span class="red chins"><s:text name="error"/></span></p>
			<p><s:text name="errortip"/><a class="return1" href="<%=request.getContextPath()%>/home.shtml"><s:text name="returnhome"/></a></p>
		</div>
	</div>
</div>
</body>
</html>