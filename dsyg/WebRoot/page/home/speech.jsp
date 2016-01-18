<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta name="keywords" content="东升盈港" />
<meta name="description" content="东升盈港" />
<meta name="author" content="javascript:" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css<s:if test='#session.language == "en"'>/style_en.css</s:if><s:else>/style.css</s:else>" />
<script src="<%=request.getContextPath()%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/loopedslider.min.js" type="text/javascript"></script>
<title><s:text name="dsyg"/>-<s:text name="presidentmessage"/></title>
<script type="text/javascript">
</script>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<div class="main">
	<div class="product_header">
		<div class="pagekv">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>banner1.png" />
		</div>
	</div>
	<div class="page_main">
		<div class="page_item">
			<div class="pro_img">
				<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>company.jpg" alt="<s:text name="companyoverview"/>">
			</div>
			<div class="pro_adress">
				<a href="#"><s:text name="home"/></a> &gt; <a href="#"><s:text name="companyoverview"/></a> &gt; <s:text name="presidentmessage"/>
			</div>
		</div>
		<div class="item_line">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>page_line.jpg">
		</div>
		<div class="pro_content">
			<div class="pro_list">
				<ul>
					<li id="list1">
						<a href="<c:url value="/home/showCompanyInfoAction.action"></c:url>"><s:text name="companyprofile"/></a>
					</li>
					<li id="list2">
						<a href="<c:url value="/home/showCompanySpeechAction.action"></c:url>" class="cur"><s:text name="presidentmessage"/></a>
					</li>
					<li id="list3">
						<a href="<c:url value="/home/showCompanyHistoryAction.action"></c:url>"><s:text name="history"/></a>
					</li>
					<li id="list4">
						<a href="<c:url value="/home/showCompanyDistributionAction.action"></c:url>"><s:text name="locations"/></a>
					</li>
					<li id="list5">
						<a href="<c:url value="/home/showCompanyRecruitAction.action"></c:url>"><s:text name="joboffers"/></a>
					</li>
				</ul>
			</div>
			<div class="company">
				<p>
					<img alt="" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>ceo.jpg"> 
				</p>
				<p class="wire_content">
					<img alt="" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>chief.jpg" height="209" width="621"> 
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="message1"/>
				</span>
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="message2"/>
				</span>
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="message3"/>
				</span>
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="message4"/>
				</span>
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="message5"/>
				</span>
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="xuminjia"/>
				</span>
				</p>
				<p>
				<span style=" font-family:微软雅黑; font-size:15px; color: #666666">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:text name="messagetime"/>
				</span>
				</p>
				</div>
			<div class="clear"></div>
			<div class="h80"></div>
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
