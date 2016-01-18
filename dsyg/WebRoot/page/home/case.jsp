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
<title><s:text name="dsyg"/>-<s:text name="casestudy"/></title>
<script type="text/javascript">
</script>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<div class="main">
	<div class="product_header">
		<div class="pagekv">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>banner7.png" />
		</div>
	</div>
	<div class="page_main">
		<div class="page_item">
			<div class="pro_img">
				<s:text name="casestudy"/>
			</div>
			<div class="pro_adress">
				<a href="#"><s:text name="home"/> </a> &gt; <s:text name="casestudy"/>				</div>
		</div>
		<div class="item_line">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>page_line.jpg">
		</div>
		<div class="pro_content">
			<div class="pro_list">
				<ul>
					<s:iterator id="homeGoodsList" value="homeGoodsList" status="st1">
						<li>
							<s:if test='%{homeGoodsList[#st1.index].code == caseFieldcode}'>
								<a href="<c:url value="/home/showHomeCaseAction.action"><c:param name="caseFieldcode" value="${code}"></c:param></c:url>" style="font-size:16px;"><font color="red"><s:property value="fieldname"/></font></a>
							</s:if>
							<s:else>
								<a href="<c:url value="/home/showHomeCaseAction.action"><c:param name="caseFieldcode" value="${code}"></c:param></c:url>" style="font-size:16px;"><s:property value="fieldname"/></a>
							</s:else>
						</li>
					</s:iterator>
				</ul>
			</div>
			<div class="news_details">
				<ul>
					<s:iterator id="homeCaseList" value="homeCaseList" status="st1">
						<li>
							<span class="news_span"></span>
								<a target="_blank" href="<c:url value="/home/showHomeCaseDetailAction.action"><c:param name="caseDetailId" value="${id}"></c:param></c:url>"><s:property value="title"/></a>
							</span>
						</li>
					</s:iterator>
				</ul>
			</div>
			<div class="clear"></div>
			<div class="h80"></div>
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
