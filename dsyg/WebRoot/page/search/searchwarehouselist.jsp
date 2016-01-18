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
<title><s:text name="dsyg"/>-<s:text name="warehousesearchlist"/></title>
<script type="text/javascript">
function turn(id) {
	var totalPage = "${page.totalPage}";
	var turnPage = $("#" +id).val();
	//判断是否输入页码
	if ('' != turnPage) {
		//判断页码是否是大于0的数字
		if(!iscInteger(turnPage)){
			alert('<s:text name="pagenumbercheck"/>');
			$("#" +id).focus();
			return;
		}
		turnPage = parseInt(turnPage);
		if(turnPage < 1){
			alert('<s:text name="pagenumbercheck"/>');
			$("#" +id).focus();
			return;
		}
		//判断页码大小是否正确
		if(turnPage > parseInt(totalPage)){
			alert('<s:text name="pagemaxcheck"/>');
			$("#" +id).focus();
			return;
		}
		//换页
		var p = turnPage - 1;
		window.location.href = '<%=request.getContextPath()%>' + "/searchwarehouse" + "${listUrl}" + "_p" + p + ".shtml";
	} else {
		alert('<s:text name="pagecodecheck"/>');
		$("#" +id).focus();
		return;
	}
}

function search() {
	var producttype = $("#producttype").val().trim();
	var productname = $("#productname").val().trim();
	var url = "";
	if(producttype != "") {
		url = "_g" + producttype;
	}
	if(productname != "") {
		url = "_name" + productname;
	}
	if(confirm('<s:text name="warehousesearchtip"/>')) {
		window.location.href = '<%=request.getContextPath()%>' + "/searchwarehouse" + url + "_p0" + ".shtml";
	}
}
</script>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<div id="main">
	<s:hidden name="producttype" id="producttype"/>
	<div class="main">
		<div class="header_bg">
			<div class="content">
				<div class="product_search">
					<div class="tittle">
					</div>
					<table width="80%" border="0" cellpadding="0" cellspacing="5">
						<tr><s:iterator id="goodsBaseList" value="goodsBaseList" status="st1"><s:if test="#st1.index < 3">
							<s:if test="%{goodsBaseList[#st1.index].code == producttype}">
								<td width="33.3%"><a href="#">
									<div class="product product_cur">
										<p><s:property value="fieldname"/></p>
										<p class="arial"><s:property value="mean"/></p>
									</div>	</a>
								</td>
							</s:if>
							<s:else>
								<td width="33.3%"><a href="<c:url value="/search/searchWarehouseListAction.action"><c:param name="producttype" value="${code}"></c:param><c:param name="startIndex" value="${startIndex}"></c:param></c:url>">
									<div class="product">
										<p><s:property value="fieldname"/></p>
										<p class="arial"><s:property value="mean"/></p>
									</div>	</a>
								</td>
							</s:else>
						</s:if></s:iterator></tr>
						<tr><s:iterator id="goodsBaseList" value="goodsBaseList" status="st1"><s:if test="#st1.index >= 3">
							<s:if test="%{goodsBaseList[#st1.index].code == producttype}">
								<td width="33.3%"><a href="#">
									<div class="product product_cur">
										<p><s:property value="fieldname"/></p>
										<p class="arial"><s:property value="mean"/></p>
									</div>	</a>
								</td>
							</s:if>
							<s:else>
								<td width="33.3%"><a href="<c:url value="/search/searchWarehouseListAction.action"><c:param name="producttype" value="${code}"></c:param><c:param name="startIndex" value="${startIndex}"></c:param></c:url>">
									<div class="product">
										<p><s:property value="fieldname"/></p>
										<p class="arial"><s:property value="mean"/></p>
									</div>	</a>
								</td>
							</s:else>
						</s:if></s:iterator></tr>
					</table>
					<div class="inventory_search">
						<s:textfield name="productname" id="productname" cssClass="keyword" maxlength="16" theme="simple"></s:textfield>
						<input type="button" class="search_btn" value="<s:text name="search"/>" onclick="search();" />
					</div>
					<div class="annotation" style="margin-top: 14px;">
						<span class="red">*</span><s:text name="explanation"/>：
						<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>instock.png" /><s:text name="existinggoods"/>
						<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>futures.png" /><s:text name="futures"/>
						<!--img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>zheng.png" />表示整箱 -->
						<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>luan.png" /><s:text name="chaosruler"/>
					</div>
					<div class="page">
						<span><s:text name="page"/> ${page.startIndex + 1} <s:text name="pageunit"/>/<s:text name="pagesizetotal"/> ${page.totalPage==0?1:page.totalPage} <s:text name="pageunit"/>　<s:text name="total"/> ${page.totalCount} <s:text name="records"/></span>
						<span><s:text name="skiptopage"/><input class="num" id="pagenum1" type="text" maxlength="6" /><s:text name="pageunit"/></span><a href="javascript:void(0);" onclick="turn('pagenum1');"><s:text name="go"/></a>　　
						<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p0.shtml"><s:text name="homepage"/></a>
						<s:if test="%{page.startIndex <= 0}">
							<a href="javascript:void(0);"><s:text name="previous"/></a>
						</s:if>
						<s:else>
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p${page.previousIndex}.shtml"><s:text name="previous"/></a>
						</s:else>
						<s:if test="%{page.nextIndex > page.totalPage - 1}">
							<a href="javascript:void(0);"><s:text name="next"/></a>
						</s:if>
						<s:else>
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p${page.nextIndex}.shtml"><s:text name="next"/></a>
						</s:else>
						<s:if test="%{page.totalPage > 0}">
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p${page.totalPage - 1}.shtml"><s:text name="lastpage"/></a>
						</s:if>
						<s:else>
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p0.shtml"><s:text name="lastpage"/></a>
						</s:else>
					</div>
					<table class="product_tab" width="100%" border="1" cellspacing="5" cellpadding="10">
						<tr class="tab_tittle">
							<td>&nbsp;</td>
							<td width="100"><s:text name="brand"/></td>
							<td width="80"><s:text name="producttype"/></td>
							<td width="160"><s:text name="productname"/></td>
							<td width="120"><s:text name="specifications"/></td>
							<td width="60"><s:text name="color"/></td>
							<td width="60"><s:text name="margin"/></td>
							<td width="60"><s:text name="unit"/></td>
							<!-- <td width="70">产地</td> -->
							<td width="70"><s:text name="deliveryexpected"/></td>
							<td width="60"></td>
						</tr>
						<s:iterator value="searchWarehouseList" id="searchWarehouseList" status="st2">
							<s:if test="#st2.odd==true">
								<tr>
							</s:if>
							<s:else>
								<tr class="bg2">
							</s:else>
								<td><s:property value="page.pageSize * (page.nextIndex - 1) + #st2.index + 1"/></td>
								<td><s:property value="brand"/></td>
								<td>
									<s:iterator id="goodsList" value="goodsList" status="st3">
										<s:if test="%{goodsList[#st3.index].code == searchWarehouseList[#st2.index].producttype}">
											<s:property value="fieldname"/>
										</s:if>
									</s:iterator>
								</td>
								<td><s:property value="productname"/></td>
								<td><s:property value="typeno"/></td>
								<td>
									<s:iterator value="colorList" id="colorList" status="st1">
										<s:if test="%{colorList[#st1.index].code == searchWarehouseList[#st2.index].color}">
											<s:property value="fieldname"/>
										</s:if>
									</s:iterator>
								</td>
								<td align="right"><s:property value="item01"/></td>
								<td>
									<s:iterator value="unitList" id="unitList" status="st1">
										<s:if test="%{unitList[#st1.index].code == searchWarehouseList[#st2.index].res01}">
											<s:property value="fieldname"/>
										</s:if>
									</s:iterator>
								</td>
								<!--
								<td>
									<s:iterator value="makeareaList" id="makeareaList" status="st1">
										<s:if test="%{makeareaList[#st1.index].code == searchWarehouseList[#st2.index].res02}">
											<s:property value="fieldname"/>
										</s:if>
									</s:iterator>
								</td>
								-->
								<td><s:property value="item03"/></td>
								<td>
									<s:if test='searchWarehouseList[#st2.index].res03 == "1"'><img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>luan.png" /></s:if>
									<!--<s:else><img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>zheng.png" /></s:else>-->
									<!--<s:if test='searchWarehouseList[#st2.index].res04 == "1"'><img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>futures.png" /></s:if>-->
									<s:if test='searchWarehouseList[#st2.index].item01 < 0'><img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>futures.png" /></s:if>
									<s:else><img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>instock.png" /></s:else>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="page">
						<span><s:text name="page"/> ${page.startIndex + 1} <s:text name="pageunit"/>/<s:text name="pagesizetotal"/> ${page.totalPage==0?1:page.totalPage} <s:text name="pageunit"/>　<s:text name="total"/> ${page.totalCount} <s:text name="records"/></span>
						<span><s:text name="skiptopage"/><input class="num" id="pagenum2" type="text" maxlength="6"/><s:text name="pageunit"/></span><a href="javascript:void(0);" onclick="turn('pagenum2');"><s:text name="go"/></a>　　
						<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p0.shtml"><s:text name="homepage"/></a>
						<s:if test="%{page.startIndex <= 0}">
							<a href="javascript:void(0);"><s:text name="previous"/></a>
						</s:if>
						<s:else>
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p${page.previousIndex}.shtml"><s:text name="previous"/></a>
						</s:else>
						<s:if test="%{page.nextIndex > page.totalPage - 1}">
							<a href="javascript:void(0);"><s:text name="next"/></a>
						</s:if>
						<s:else>
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p${page.nextIndex}.shtml"><s:text name="next"/></a>
						</s:else>
						<s:if test="%{page.totalPage > 0}">
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p${page.totalPage - 1}.shtml"><s:text name="lastpage"/></a>
						</s:if>
						<s:else>
							<a href="<%=request.getContextPath()%>/searchwarehouse<s:property value="listUrl"/>_p0.shtml"><s:text name="lastpage"/></a>
						</s:else>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
