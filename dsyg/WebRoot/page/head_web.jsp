<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css<s:if test='#session.language == "en"'>/style_en.css</s:if><s:else>/style.css</s:else>" />
<script type="text/javascript">
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?cc24123a5b149a40daa3f4b4a6895b0c";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();

	function manageLogout() {
		//window.location.href = '<c:url value="/manage/manageLogoutAction.action"></c:url>';
	}
	
	//多语言切换
	function changeLanguage() {
		var url = window.location.href;
		if(url.indexOf("?language=") >= 0) {
			//解析地址
			var list1 = url.split("?language=");
			var list2 = list1[1].split("&");
			url = list1[0] + "?language=" + document.getElementById("language").value;
			if(list2.length > 1) {
				for(var i = 1; i < list2.length; i++) {
					url += "&" + list2[i];
				}
			}
		} else if(url.indexOf("&language=") >= 0) {
			//解析地址
			var list1 = url.split("&language=");
			var list2 = list1[1].split("&");
			url = list1[0] + "&language=" + document.getElementById("language").value;
			if(list2.length > 1) {
				for(var i = 1; i < list2.length; i++) {
					url += "&" + list2[i];
				}
			}
		} else {
			if(url.indexOf("?") >= 0) {
				url += "&language=" + document.getElementById("language").value;
			} else {
				url += "?language=" + document.getElementById("language").value;
			}
		}
		window.location.href = url;
	}
</script>
<div id="top">
	<div class="top">
		<div class="menu">
			<ul>
				<li><a href="home.shtml"><s:text name="home"/></a></li>
				<li><a href="showInformation.shtml"><s:text name="titletechnicalinfo"/></a></li>
				<li><a href="searchhome.shtml"><s:text name="productinfo"/></a></li>
				<li><a href="companyinfo.shtml"><s:text name="titlecompanyinfo"/></a></li>
				<li><a href="companynews.shtml"><s:text name="titlecompanynews"/></a></li>
				<li><a href="qa.shtml"><s:text name="qainfo"/></a></li>
				<li><a href="case_p01.shtml"><s:text name="casestudy"/></a></li>
				<!-- <li><a href="showsearchsarehouse.shtml"><s:text name="inventory"/></a></li> -->
				<li><a href="showpopproduct.shtml"><s:text name="popproduct"/></a></li>
				<li><a href="showinventory.shtml"><s:text name="inventory"/></a></li>
				<!-- <li><a href="showOnline.shtml"><s:text name="buyonline"/></a></li> -->
				<li><a href="../../dsygonline/"><s:text name="buyonline"/></a></li>
				<!--
				<li><a href="<c:url value="/home/goHomeAction.action"></c:url>">首页</a></li>
				<li><a href="<c:url value="/search/showSearchAction.action"></c:url>">产品信息</a></li>
				<li><a href="<c:url value="/home/showInformationAction.action"></c:url>">相关技术情报</a></li>
				<li><a href="<c:url value="/home/showCompanyInfoAction.action"></c:url>">公司信息</a></li>
				<li><a href="<c:url value="/home/showCompanyNewAction.action"></c:url>">公司新闻</a></li>
				<li><a href="<c:url value="/home/showQaAction.action"></c:url>">咨询信息Q/A</a></li>
				<li><a href="<c:url value="/home/showHomeCaseAction.action"><c:param name="caseFieldcode" value="01"></c:param></c:url>">案例介绍</a></li>
				<li><a href="<c:url value="/search/showSearchWarehouseAction.action"></c:url>">库存信息</a></li>
				<li><a href="<c:url value="/home/showOnlineAction.action"></c:url>">线上购买</a></li>
				-->
			</ul>
		</div>
		<div class="logo">
			<a href="home.shtml"></a>			
		</div>
		<!-- <div class="test fr"><s:text name="testrun"/></div> -->
		<div style="float:right; margin-top: 10px;">CHANGE LANGUAGE: <br>
			<select id="language" name="language" style="width: 100px;" onchange="changeLanguage();">
				<s:if test='#session.language == "en"'>
					<option value="zh">中文</option>
					<option value="en" selected="selected">English</option>
				</s:if>
				<s:else>
					<option value="zh" selected="selected">中文</option>
					<option value="en">English</option>
				</s:else>
			</select>
		</div>
	</div>
</div>