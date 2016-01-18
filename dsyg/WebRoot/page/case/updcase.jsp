<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Calendar3.js"></script>
<title>东升盈港-案例更新</title>
<script type="text/javascript">
	function upd() {
		if(checkData()) {
			if(confirm("确定更新吗？")) {
				document.mainform.action = '<c:url value="/case/updCaseAction.action"></c:url>';
				document.mainform.submit();
			}
		}
	}
	
	function checkData() {
		var title = $("#title").val().trim();
		var fieldcode = $("#fieldcode").val().trim();
		var tempData = $("#tempData").val();
		if(title == "") {
			alert("标题不能为空！");
			$("#title").focus();
			return false;
		}
		if(fieldcode == "") {
			alert("请选择产品类型！");
			$("#fieldcode").focus();
			return false;
		}
		//图片验证
		var file01Name = $("#updPicFile01").val();
		//图1
		if(file01Name != "") {
			var n = file01Name.substring(file01Name.lastIndexOf("."), file01Name.length).toUpperCase();
			if(n != ".JPG" && n != ".GIF" && n != ".PNG") {
				alert("图片只支持JPG、GIF和PNG格式！");
				$("#updPicFile01").focus();
				return false;
			}
			//文件名
			$("#file01Name").val(file01Name);
		}
		
		if(tempData == "") {
			alert("新闻内容不能为空！");
			$("#tempData").focus();
			return false;
		}
		if(tempData.length > 2500) {
			alert("新闻内容不能超过2500个字！");
			$("#tempData").focus();
			return false;
		}
		$("#data").val(tempData);
		return true;
	}
	
	function goBack() {
		document.mainform.action = '<c:url value="/case/queryCaseAction.action"></c:url>';
		document.mainform.submit();
	}
	
	//删除图片
	function delPic(id1, id2, id3) {
		$("#" + id1).remove();
		$("#" + id2).remove();
		//清空图片地址
		$("#" + id3).val("");
	}
</script>
</head>
<body style="background: url(''); overflow-x:hidden;overflow-y:scroll;">
<div id="main" style="margin-top:2px;">
	<div class="header_bg">
		<div class="content warehouse_input">
			<div class="user_bg">
				<div class="user">
					<div class="user_tittle">后台管理------案例更新
					</div>
				</div>
			</div>
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST" enctype="multipart/form-data">
					<s:hidden name="updCaseDto.data" id="data"></s:hidden>
					<s:hidden name="file01Name" id="file01Name"></s:hidden>
					<s:hidden name="updCaseDto.pic01" id="pic01"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<table class="input_table" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span>标题：</td>
							<td>
								<s:textfield name="updCaseDto.title" id="title" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>产品类型：</td>
							<td>
								<select name="updCaseDto.fieldcode" id="fieldcode" style="width: 305px;">
									<option value="">请选择</option>
									<s:iterator value="goodsList" id="goodsList" status="st1">
										<option value="<s:property value="code"/>" <s:if test="%{goodsList[#st1.index].code == updCaseDto.fieldcode}">selected</s:if>><s:property value="fieldname"/></option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span></span>图片上传：</td>
							<td>
								<input type="file" style="width: 305px;" name="updPicFile01" id="updPicFile01"/><br />
								<s:if test='updCaseDto.pic01 != null && updCaseDto.pic01 != ""'>
									<img id="tmppic01" src="<s:property value="updCaseDto.casePicUrl"/><s:property value="updCaseDto.pic01"/>" alt="" /><br />
									<a id="tmpdel1" href="javascript:void(0);" onclick="delPic('tmppic01', 'tmpdel1', 'pic01')">删除</a>
								</s:if>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>内容：</td>
							<td>
								<textarea rows="10" cols="50" style="width:300px;" id="tempData"><s:property value="updCaseDto.data"/></textarea>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn btn-blue" type="button" value="保存" onclick="upd();"/>
								<input class="btn btn-gray" type="button" value="返回" onclick="goBack();"/>
							</td>
						</tr>
					</table>
				</s:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
