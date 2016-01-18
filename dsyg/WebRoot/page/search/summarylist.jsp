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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<title><s:text name="dsyg"/>-<s:text name="summary"/></title>
<script type="text/javascript">
	//列表页面
	function showlist() {
		var url = "";
		var goodsId = $("#tmpGoodsId").val().trim();
		var item01 = $("#tempItem01").val().trim();
		var item02 = $("#tempItem02").val().trim();
		var item03 = $("#tempItem03").val().trim();
		var item04 = $("#tempItem04").val().trim();
		var keyword = $("#tempKeyword").val().trim();
		if(goodsId != "") {
			
		} else {
			window.location.href = '<%=request.getContextPath()%>' + "/searchsummary_kw" + keyword + ".shtml";
		}
	}
</script>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<div class="main">
	<input type="hidden" id="tmpGoodsId" value="<s:property value="goodsId"/>"/>
	<input type="hidden" id="tempItem01" value="<s:property value="item01"/>"/>
	<input type="hidden" id="tempItem02" value="<s:property value="item02"/>"/>
	<input type="hidden" id="tempItem03" value="<s:property value="item03"/>"/>
	<input type="hidden" id="tempItem04" value="<s:property value="item04"/>"/>
	<input type="hidden" id="tempKeyword" value="<s:property value="keyword"/>"/>
	<div class="content">
		<div class="product_search">
			<div class="tittle">
			</div>
			<div class="search_result">
			<span class="red"><s:property value="summaryCount"/></span> <s:text name="befound"/>
			</div>
			<table class="product_tab font16" width="100%" border="1" cellspacing="5" cellpadding="5">
				<s:iterator id="product01SummaryList" value="product01SummaryList" status="st1">
					<tr>
						<td class="bgeee" width="145"><a href="<%=request.getContextPath()%>/searchlist_g<s:property value="fieldcode"/><s:property value="summaryUrl"/>"><img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>product<s:property value="fieldcode"/>.jpg" border="0" alt="" /></a></td>
						<td class="bgefe">
							<s:iterator value="goodsList" id="goodsList" status="st2">
								<s:if test="%{goodsList[#st2.index].code == product01SummaryList[#st1.index].fieldcode}">
									<a href="<%=request.getContextPath()%>/searchlist_g${product01SummaryList[st1.index].fieldcode}<s:property value="summaryUrl"/>">
										<span class="fw600 percent15"><s:property value="fieldname"/></span> <s:text name="productfound"/> <span class="red"><s:property value="num"/></span> <s:text name="piece"/>
									</a>
								</s:if>
							</s:iterator>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</div>
</body>
</html>
