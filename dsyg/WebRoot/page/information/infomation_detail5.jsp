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
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN01.png" /><br><s:text name="infodetail501"/></p>
							<h2>
								<!-- <img alt="infodetail501" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_01.png" width="300" height="181"> -->
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN02.png" /><br><s:text name="infodetail502"/></p>
							<h2>
								<!-- <img alt="infodetail502" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_02.png" width="300" height="181"> -->
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN03.png" /><br><s:text name="infodetail503"/></p>
							<h2>
								<!--<img alt="infodetail503" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_03.png" width="300" height="181"> -->
							</h2>
						</div>
						<div class="clear"></div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN04.png" /><br><s:text name="infodetail504"/></p>
							<h2>
								<img alt="infodetail504" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_04.png" width="300" height="181" />
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN05.png" /><br><s:text name="infodetail505"/></p><br>
							<h2>
								<img alt="infodetail505" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_05.png" width="300" height="181" />
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN06.png" /><br><s:text name="infodetail506"/></p>
							<h2>
								<img alt="infodetail506" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_06.png" width="300" height="181" />
							</h2>
						</div>
						<div class="clear"></div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN07.png" /><br><s:text name="infodetail507"/></p>
							<h2>
								<img alt="infodetail507" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_07A.png" width="300" height="181" />
								<img alt="infodetail507" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_07B.png" width="300" height="181" />
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN08.png" /><br><s:text name="infodetail508"/></p>
							<h2>
								<img alt="infodetail508" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_08A.png" width="300" height="181" />
								<img alt="infodetail508" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_08B.png" width="300" height="181" />
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN09.png" /><br><s:text name="infodetail509"/></p>
							<h2>
								<img alt="infodetail509" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_09A.png" width="300" height="181" />
								<img alt="infodetail509" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_09B.png" width="300" height="181" />
							</h2>
						</div>
						<div class="clear"></div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN10.png" /><br><s:text name="infodetail510"/></p>
							<h2>
								<!-- <img alt="infodetail510" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_10.png" width="300" height="181"> -->
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN11.png" /><br><s:text name="infodetail511"/></p>
							<h2>
								<img alt="infodetail511" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_11.png" width="300" height="181" />
							</h2>
						</div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN12.png" /><br><s:text name="infodetail512"/></p>
							<h2>
								<!-- <img alt="infodetail512" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_12.png" width="300" height="181"> -->
							</h2>
						</div>
						<div class="clear"></div>
						<div class="caseBox2">
							<p><img src="<%=request.getContextPath()%>/images/imgN13.png" /><br><s:text name="infodetail513"/></p>
							<h2>
								<img alt="infodetail513" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>img5_13.png" width="300" height="181" />
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
