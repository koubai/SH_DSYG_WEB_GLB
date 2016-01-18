<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css<s:if test='#session.language == "en"'>/style_en.css</s:if><s:else>/style.css</s:else>" />
<script type="text/javascript">
	function manageLogout() {
		//window.location.href = '<c:url value="/manage/manageLogoutAction.action"></c:url>';
	}
</script>
<div class="yzk_bottom">
	<p><s:text name="shdsyg"/> <span style=" margin-left:40px; font-weight:normal; font-family:times; font-size:10px; color:#959595;">Copyright＠ D.S.Y.G Trade LTD. ALL Rights Reserved.</span></p>
	<div class="contactus">
		<ul>
			<li><a href="<c:url value="/home/showCompanyInfoAction.action"></c:url>"><s:text name="contactus"/></a><span><img src="images/line.jpg" /></span></li>
			<li><a href="#"><s:text name="sitemap"/></a><span><img src="images/line.jpg" /></span></li>
			<li><a href="#"><s:text name="privacy"/></a></li>
		</ul>
		<ul>
			<li style="padding-left:40px;"><a href="http://www.miitbeian.gov.cn/"><s:text name="icpno"/></a></li>
		</ul>
	</div>
</div>