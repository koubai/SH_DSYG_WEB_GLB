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
<title>
<s:if test="recruitDetail != null">
<s:text name="dsyg"/>-<s:text name="joboffersdetail"/>-<s:property value="recruitDetail.title"/>
</s:if>
<s:else>
<s:text name="dsyg"/>-<s:text name="joboffersdetail"/>
</s:else>
</title>
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
				<s:text name="joboffers"/>
			</div>
			<div class="pro_adress">
				<a href="<%=request.getContextPath()%>/"><s:text name="home"/> </a> &gt; <a href="<%=request.getContextPath()%>/companyinfo.shtml"> <s:text name="joboffers"/></a> &gt; <s:text name="joboffersdetail"/>
			</div>
		</div>
		<div class="item_line">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>page_line.jpg">
		</div>
		<div class="pro_content">
			<div class="pro_list">
			</div>
			<div class="news_details">
				<p class="news_tit"><s:property value="recruitDetail.title"/></p>
				<div class="newscontent">
					<p>${recruitDetail.data}</p>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
