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
<title><s:text name="dsyg"/>-<s:text name="tchenicalinfo"/></title>
<script type="text/javascript">
</script>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<div class="main">
	<div id="contents">
		<!--////////// main start -->
		<h1 class="ttl w960"><s:text name="infodetailtitle"/></h1>
		<div class="borderTop">
			<div id="blue-mat">
				<div class="w960">
					<p class="item"><s:text name="infodetailtip"/></p>
				</div>
			</div>
		</div>
		<!--////////// 説明部分 start -->
			<div class="content">
				<div class="fBox">
					<div class="caseBox">
						<h2>
							<img alt="絶縁・保護" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_01.png" width="324" height="181"></h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="防水チューブ/キャップ" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_02.png" width="324" height="181">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="塗装の代替・装飾 /防食" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_03.png" width="324" height="181">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="ゆるみ防止・固定" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_04.png" width="324" height="181">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="識別用途" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_05.png" width="324" height="181">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="耐薬品性/耐油性" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_06.png" width="324" height="181">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="識別用途" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_07.png" width="324" height="181">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="耐薬品性/耐油性" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img6_08.png" width="324" height="181">
						</h2>
					</div>
					<!--fBox -->
					<div class="clear"></div>
				</div>
			</div>
		<!--////////// 説明部分 end -->
		<!--contents -->
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
