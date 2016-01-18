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
<title>东升盈港-库存修改</title>
<script type="text/javascript">
	function upd() {
		if(checkData()) {
			if(confirm("确定修改吗？")) {
				document.mainform.action = '<c:url value="/warehouse/updWarehouseAction.action"></c:url>';
				document.mainform.submit();
			}
		}
	}
	
	function checkData() {
		var item01 = $("#item01").val().trim();
		var res01 = $("#res01").val().trim();
		var item03 = $("#item03").val().trim();
		var res02 = $("#res02").val().trim();
		if(item01 != "" && !isReal(item01)) {
			alert("在库数必须是大于0的数字！");
			$("#item01").focus();
			return false;
		}
		if(res01 == "") {
			alert("请选择单位！");
			$("#res01").focus();
			return false;
		}
		if(item03 == "") {
			alert("发送天数不能为空！");
			$("#item03").focus();
			return false;
		}
		if(!isNumber(item03)) {
			alert("发送天数必须是大于0的整数！");
			$("#item03").focus();
			return false;
		}
		if(res02 == "") {
			alert("请选择产地！");
			$("#res02").focus();
			return false;
		}
		//整箱OR乱尺（1整箱0乱尺）
		if($("#tmpRes03").attr("checked")) {
			$("#res03").val("1");
		} else {
			$("#res03").val("0");
		}
		//期货OR现货（1期货0现货）
		if($("#tmpRes04").attr("checked")) {
			$("#res04").val("1");
		} else {
			$("#res04").val("0");
		}
		return true;
	}
	
	function goBack() {
		document.mainform.action = '<c:url value="/warehouse/queryWarehouseListAction.action"></c:url>';
		document.mainform.submit();
	}
</script>
</head>
<body style="background: url(''); overflow-x:hidden;overflow-y:scroll;">
<div id="main" style="margin-top:2px;">
	<div class="header_bg">
		<div class="content warehouse_input">
			<div class="user_bg">
				<div class="user">
					<div class="user_tittle">后台管理------库存修改
					</div>
				</div>
			</div>
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST" enctype="multipart/form-data">
					<s:hidden name="updWarehouseDto.productid" id="productid"></s:hidden>
					<s:hidden name="updWarehouseDto.res03" id="res03"></s:hidden>
					<s:hidden name="updWarehouseDto.res04" id="res04"></s:hidden>
					<s:hidden name="queryProductId" id="queryProductId"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<table class="input_table" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span>库存编辑：</td>
							<td>
								<dl>
									<dt>数量：</dt>
									<dd>
										<s:textfield name="updWarehouseDto.item01" id="item01" cssStyle="width:300px;" maxlength="10" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>乱尺：</dt>
									<dd>
										<s:if test='updWarehouseDto.res03 == "1"'>
											<input id="tmpRes03" type="checkbox" checked="checked" value="1" />
										</s:if>
										<s:else>
											<input id="tmpRes03" type="checkbox" value="1" />
										</s:else>
									</dd>
								</dl>
								<dl>
									<dt>单位：</dt>
									<dd>
										<select name="updWarehouseDto.res01" id="res01">
											<s:iterator value="unitList" id="unitList" status="st2">
												<option value="<s:property value="code"/>" <s:if test="%{unitList[#st2.index].code == updWarehouseDto.res01}">selected</s:if>><s:property value="fieldname"/></option>
											</s:iterator>
										</select>
									</dd>
								</dl>
								<dl>
									<dt>发送天数：</dt>
									<dd>
										<s:textfield name="updWarehouseDto.item03" id="item03" cssStyle="width:300px;" maxlength="10" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>期货：</dt>
									<dd>
										<s:if test='updWarehouseDto.res04 == "1"'>
											<input id="tmpRes04" type="checkbox" checked="checked" value="1" />
										</s:if>
										<s:else>
											<input id="tmpRes04" type="checkbox" value="1" />
										</s:else>
									</dd>
								</dl>
								<dl>
									<dt>产地：</dt>
									<dd>
										<select name="updWarehouseDto.res02" id="res02">
											<s:iterator value="makeareaList" id="makeareaList" status="st2">
												<option value="<s:property value="code"/>" <s:if test="%{makeareaList[#st2.index].code == updWarehouseDto.res02}">selected</s:if>><s:property value="fieldname"/></option>
											</s:iterator>
										</select>
									</dd>
								</dl>
							</td>
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
