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
	<div class="product_header">
		<div class="pagekv">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>banner2.png" />
		</div>
	</div>
	<div class="content">
		<div class="products_info">
			<table width="80%" border="0" cellpadding="0" cellspacing="10">
			  <tbody><tr>
				<td width="25%"><a href="<c:url value="/home/showInformationDetail1Action.action"></c:url>">
					<div class="product">
						<p>電子線</p>
						<p class="arial">Electronic Wire</p>
					</div>		</a>					
				</td>
				<td width="25%"><a href="<c:url value="/home/showInformationDetail2Action.action"></c:url>">
					<div class="product">
						<p>熱収束套管</p>
						<p class="arial">Heat-Shrink-Tube</p>
					</div>	</a>						
				</td>
				<td width="25%"><a href="<c:url value="/home/showInformationDetail1Action.action"></c:url>">
					<div class="product">
						<p>柔軟扁平電纜</p>
						<p class="arial">Flexible Flat Cable</p>
					</div>	</a>						
				</td>
				<td width="25%"><a href="<c:url value="/home/showInformationDetail7Action.action"></c:url>">
					<div class="product">
						<p>标识和标签</p>
						<p class="arial">SumiTag SumiLabel</p>
					</div>	</a>						
				</td>
			  </tr>
			  <tr>
			  <td><a href="<c:url value="/home/showInformationDetail4Action.action"></c:url>">
					<div class="product">
						<p>漆包線</p>
						<p class="arial">Magnesium Alloy</p>
					</div>	</a>						
				</td>

				<td><a href="<c:url value="/home/showInformationDetail5Action.action"></c:url>">
					<div class="product">
						<p>線束加工</p>
						<p class="arial">Wiring Harness</p>
					</div>	</a>						
				</td>
				<td><a href="<c:url value="/home/showInformationDetail6Action.action"></c:url>">
					<div class="product">
						<p>柔軟印刷电路板</p>
						<p class="arial">Flexible Printed Circuit Bd</p>
					</div>		</a>					
				</td>
				<td>
				</td>
			  </tr>
			</tbody></table>
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
