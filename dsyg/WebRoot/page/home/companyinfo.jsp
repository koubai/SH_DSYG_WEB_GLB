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
<title><s:text name="dsyg"/>-<s:text name="companyinfo"/></title>
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
				<a href="<%=request.getContextPath()%>/"><s:text name="home"/> </a> &gt; <a href=""<%=request.getContextPath()%>/companyinfo.shtml"><s:text name="companyoverview"/></a> &gt; <s:text name="companyprofile"/>
			</div>
		</div>
		<div class="item_line">
			<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>page_line.jpg">
		</div>
		<div class="pro_content">
			<div class="pro_list">
				<ul>
					<li id="list1">
						<a href="<c:url value="/home/showCompanyInfoAction.action"></c:url>" class="cur"><s:text name="companyprofile"/></a>
					</li>
					<li id="list2">
						<a href="<c:url value="/home/showCompanySpeechAction.action"></c:url>"><s:text name="presidentmessage"/></a>
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
			<div class="capital">
				<p class="wire_content">
					<img alt="<s:text name="businessconcepts"/>" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>mimg1.jpg" height="226" width="639"> 
				</p>
				<!-- 
				<div class="capital_heights">
				</div>
				<div class="capital_details">
					<p class="basic_rules">
						经营基本方针
					</p>
					<ul>
						<h3>
							東升盈港为了实现经营理念，以下述方针为准则，开展经营活动。
						</h3>
						<li>
							通过新发明的想法以及不懈的努力提高企业的效率，为全世界的顾客提供最大化的价值。
						</li>
						<li>
							在遵守法律和地域文化前提下展开企业活动，为社会发展贡献力量。
						</li>
						<li>
							把环境和安全作为最优先的企业活动，为实现繁荣社会作出贡献。
						</li>
						<li>
							为开放公平交易作出努力，为共发展共繁荣作出贡献。
						</li>
						<li>
							尊重人才，创造最大化发挥个人和团队能力的公司环境，为每个人的梦想作出贡献。
						</li>
					</ul>
				</div>
				 -->
				<!--
				<div class="capital_details nostyle">
					<ul>
						<p class="basic_rules">
							多样事业的展开
						</p>
						<li>
							汽车机器部门<br>
				汽车线束、仪表盘、车载机器
						</li>
						<li>
							生活环境机器部门<br>
				电线、燃气设备、环境系统机器、住宅设备机器
						</li>
						<li>
							新事业<br>
				废品再利用事业、看护事业、农业事业
						</li>
					</ul>
				</div>
				<div class="capital_details nostyle">
					<ul>
						<p class="basic_rules">
							国际化的事业展开
						</p>
						<li>
							43个国家，160个法人，444据点（包含日本）（2013年6月20日）
						</li>
					</ul>
				</div>
				<div class="capital_heights2">
				</div>
				-->
				<p class="tabletit">
					<s:text name="companyprofile"/>
				</p>
				<p class="basic_rules">
					<h3>
					<s:text name="dsyglinian"/>
					</h3>
				</p>
			  <div class="cap_table">
					<table class="ke-zeroborder" cellpadding="0" cellspacing="0" border="0" width="660">
						<tbody>
							<tr>
								<td class="cap_tab1">
									<s:text name="name"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="dsygtrade"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="onaddress"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="yangpu760"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="registered"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="registeredtime1"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="capital"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="rmb500000"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="contactcompany"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="tell"/>：021－65388038－0（<s:text name="switchboard"/>）<br /><s:text name="fax"/>：021－65387551</td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="email"/>								</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2">Mail：sales@shdsyg.com<br /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="cap_table" style="margin-top:10px;">
					<table class="ke-zeroborder" cellpadding="0" cellspacing="0" border="0" width="660">
						<tbody>
							<tr>
								<td class="cap_tab1">
									<s:text name="name"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="dsygcompnay"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="onaddress"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="yangpu760"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="registered"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="registeredtime2"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="capital"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="rmb5000000"/></td>
							</tr>
							<tr>
								<td class="cap_tab1"><s:text name="funders"/></td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="invested"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="contact"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="tell"/>：021－65388038－0（<s:text name="switchboard"/>）<br /><s:text name="fax"/>：021－65387551</td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="email"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2">Mail：sales@shdsyg.com<br /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="cap_table" style="margin-top:10px;">
					<table class="ke-zeroborder" cellpadding="0" cellspacing="0" border="0" width="660">
						<tbody>
							<tr>
								<td class="cap_tab1">
									<s:text name="name"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="szdsyg"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="onaddress"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="szaddress"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="registered"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="registeredtime3"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="capital"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="rmb1500000"/></td>
							</tr>
							<tr>
								<td class="cap_tab1"><s:text name="funders"/></td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="invested"/></td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="contact"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2"><s:text name="tell"/>：0755－23319126－0（<s:text name="switchboard"/>）<br /><s:text name="fax"/>：0755－61524200</td>
							</tr>
							<tr>
								<td class="cap_tab1">
									<s:text name="email"/>									</td>
								<td class="cap_tab3">
									<br>									</td>
								<td class="cap_tab2">Mail：sales@shdsyg.com<br /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="clear"></div>
			<div class="h80"></div>
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
