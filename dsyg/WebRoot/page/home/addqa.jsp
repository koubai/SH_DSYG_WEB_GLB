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
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<script src="<%=request.getContextPath()%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/loopedslider.min.js" type="text/javascript"></script>
<title><s:text name="dsyg"/>-<s:text name="qainfo"/></title>
<script type="text/javascript">
function add() {
	if(checkData()) {
		if(confirm('<s:text name="tosubmit"/>')) {
			document.mainform.action = '<c:url value="/home/addQaAction.action"></c:url>';
			document.mainform.submit();
		}
	}
}

function checkData() {
	var title = $("#title").val().trim();
	var fullname = $("#fullname").val().trim();
	var company = $("#company").val().trim();
	var address = $("#address").val().trim();
	var tell = $("#tell").val().trim();
	var fax = $("#fax").val().trim();
	var email = $("#email").val().trim();
	var verificationcode = $("#verificationcode").val().trim();
	var tempData = $("#tempData").val();
	if(title == "") {
		alert('<s:text name="qatitlecheck"/>');
		$("#title").focus();
		return false;
	}
	
	if(tempData == "") {
		alert('<s:text name="qacontentcheck"/>');
		$("#tempData").focus();
		return false;
	}
	if(tempData.length > 2500) {
		alert('<s:text name="qacontentlengthcheck"/>');
		$("#tempData").focus();
		return false;
	}
	$("#data").val(tempData);
	
	if(fullname == "") {
		alert('<s:text name="qausernamecheck"/>');
		$("#fullname").focus();
		return false;
	}
	if(company == "") {
		alert('<s:text name="qacompanynamecheck"/>');
		$("#company").focus();
		return false;
	}
	if(address == "") {
		alert('<s:text name="qaaddresscheck"/>');
		$("#address").focus();
		return false;
	}
	if(tell == "") {
		alert('<s:text name="qatelcheck"/>');
		$("#tell").focus();
		return false;
	}
	if(fax == "") {
		alert('<s:text name="qafaxcheck"/>');
		$("#fax").focus();
		return false;
	}
	if(email == "") {
		alert('<s:text name="qamailcheck"/>');
		$("#email").focus();
		return false;
	}
	if(verificationcode == "") {
		alert('<s:text name="qaverificationcodecheck"/>');
		$("#verificationcode").focus();
		return false;
	}
	return true;
}

/**
 * 获取验证码
 * @param obj
 * @return
 */
function changeValidateCode(obj) {
	//获取当前的时间作为参数，无具体意义
    var timenow = new Date().getTime();
    //每次请求需要一个不同的参数，否则可能会返回同样的验证码
    //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
    obj.src='<%=request.getContextPath()%>/index/qarand.action?d='+timenow;
    return false;
}

/**
 * 获取验证码
 * @param obj
 * @return
 */
function changeValidate(id) {
	var timenow = new Date().getTime();
	if(document.getElementById(id) != null) {
		document.getElementById(id).src='<%=request.getContextPath()%>/index/qarand.action?d='+timenow;
	}
}
</script>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<div id="main">
	<div class="main">
		<div class="product_header">
			<div class="pagekv">
				<img src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>banner9.png" />
			</div>
		</div>
		<div class="content">
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST">
					<s:hidden name="addQaDto.data" id="data"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<br><p><s:text name="qatip"/></p>
					</br>
					<table class="input_tableQA" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="title"/>：</td>
							<td>
								<!--<s:textfield name="addQaDto.title" id="title" maxlength="64" theme="simple"></s:textfield>-->
								<select name="addQaDto.title" id="title" style="width:300px;">
									<option value="<s:text name="qaproductconsulting"/>"><s:text name="qaproductconsulting"/></option>
									<option value="<s:text name="priceapply"/>"><s:text name="priceapply"/></option>
									<option value="<s:text name="other"/>"><s:text name="other"/></option>
								</select>
							</td>
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="content"/>：</td>
							<td>
								<textarea rows="8" cols="40" style="width:300px;" id="tempData"><s:property value="addQaDto.data"/></textarea>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="username"/>：</td>
							<td>
								<s:textfield name="addQaDto.fullname" id="fullname" maxlength="32" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="companyname"/>：</td>
							<td>
								<s:textfield name="addQaDto.company" id="company" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="address"/>：</td>
							<td>
								<s:textfield name="addQaDto.address" id="address" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="tell"/>：</td>
							<td>
								<s:textfield name="addQaDto.tell" id="tell" maxlength="32" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span><s:text name="fax"/>：</td>
							<td>
								<s:textfield name="addQaDto.fax" id="fax" maxlength="32" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>Email：</td>
							<td>
								<s:textfield name="addQaDto.email" id="email" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>验证码：</td>
							<td>
								<div id="qa_vcode_item" class="form-item" style="display: block;">
									<div class="form-field">
										<div class="qa-vcode-text">
											<input type="text" class="form-text" name="addQaDto.verificationcode" id="verificationcode" maxlength="4" value="<s:property value="addQaDto.verificationcode"/>" />
											<a id="get_qa_vcode" class="get-qa-vcode" href="javascript:void(0);"><img title="看不清点我" id="randomImg" name="random" src="<c:url value="/index/qarand.action" />" onclick="changeValidateCode(this)" /></a>
 										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn btn-blue" name="" type="button" onclick="add();" value="<s:text name="submit"/>" />						
							</td>
						</tr>
						
					</table>
				</s:form>
			</div>					
		</div>
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
