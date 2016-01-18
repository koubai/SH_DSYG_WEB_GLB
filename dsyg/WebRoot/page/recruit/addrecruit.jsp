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
<title>东升盈港-招聘信息输入</title>
<script type="text/javascript">
	function add() {
		if(checkData()) {
			if(confirm("确定添加吗？")) {
				document.mainform.action = '<c:url value="/recruit/addRecruitAction.action"></c:url>';
				document.mainform.submit();
			}
		}
	}
	
	function checkData() {
		var title = $("#title").val().trim();
		var persons = $("#persons").val().trim();
		var tempData = $("#tempData").val();
		if(title == "") {
			alert("标题不能为空！");
			$("#title").focus();
			return false;
		}
		if(persons == "") {
			alert("招聘人数不能为空！");
			$("#persons").focus();
			return false;
		}
		if(!isNumber(persons)) {
			alert("招聘人数必须是大于0的数字！");
			$("#persons").focus();
			return false;
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
		document.mainform.action = '<c:url value="/recruit/queryRecruitAction.action"></c:url>';
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
					<div class="user_tittle">后台管理------招聘信息输入
					</div>
				</div>
			</div>
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST" enctype="multipart/form-data">
					<s:hidden name="addRecruitDto.data" id="data"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<table class="input_table" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span>标题：</td>
							<td>
								<s:textfield name="addRecruitDto.title" id="title" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>招聘人数：</td>
							<td>
								<s:textfield name="addRecruitDto.persons" id="persons" cssStyle="width:300px;" maxlength="10" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>内容：</td>
							<td>
								<textarea rows="10" cols="50" style="width:300px;" id="tempData"><s:property value="addRecruitDto.data"/></textarea>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn btn-blue" type="button" value="保存" onclick="add();"/>
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
