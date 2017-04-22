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
<title>东升盈港-新闻输入</title>
<script type="text/javascript">
	function add() {
		if(checkData()) {
			if(confirm("确定添加吗？")) {
				document.mainform.action = '<c:url value="/news/addNewsAction.action"></c:url>';
				document.mainform.submit();
			}
		}
	}
	
	function checkData() {
		var title = $("#title").val().trim();
		var author = $("#author").val().trim();
		var tmpnewsdate = $("#tmpnewsdate").val().trim();
		var tempData = $("#tempData").val();
		if(title == "") {
			alert("新闻标题不能为空！");
			$("#title").focus();
			return false;
		}
		if(author == "") {
			alert("作者不能为空！");
			$("#author").focus();
			return false;
		}
		if(tmpnewsdate == "") {
			alert("新闻日期不能为空！");
			$("#tmpnewsdate").focus();
			return false;
		}
		//图片验证
		var file01Name = $("#addPicFile01").val();
		//图1
		if(file01Name != "") {
			var n = file01Name.substring(file01Name.lastIndexOf("."), file01Name.length).toUpperCase();
			if(n != ".JPG" && n != ".GIF" && n != ".PNG") {
				alert("图片只支持JPG、GIF和PNG格式！");
				$("#addPicFile01").focus();
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
		$("#newsdate").val(tmpnewsdate);
		$("#data").val(tempData);
		$("#endata").val($("#tempEnData").val());
		return true;
	}
	
	function goBack() {
		document.mainform.action = '<c:url value="/news/queryNewsAction.action"></c:url>';
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
					<div class="user_tittle">后台管理------新闻输入
					</div>
				</div>
			</div>
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST" enctype="multipart/form-data">
					<s:hidden name="addNewsDto.newsdate" id="newsdate"></s:hidden>
					<s:hidden name="addNewsDto.data" id="data"></s:hidden>
					<s:hidden name="addNewsDto.endata" id="endata"></s:hidden>
					<s:hidden name="file01Name" id="file01Name"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<table class="input_table" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span>标题：</td>
							<td>
								<s:textfield name="addNewsDto.title" id="title" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span></span>英文版标题：</td>
							<td>
								<s:textfield name="addNewsDto.entitle" id="entitle" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>作者：</td>
							<td>
								<s:textfield name="addNewsDto.author" id="author" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>新闻日期：</td>
							<td>
								<div class="date_input">
									<input type="text" id="tmpnewsdate" disabled="disabled" value="<s:property value="addNewsDto.newsdate"/>"/>
									<a href="javascript:;" onclick="new Calendar().show(document.getElementById('tmpnewsdate'));"><img src="<%=request.getContextPath()%>/images/date.png" border="0" /></a>
								</div>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span></span>图片上传：</td>
							<td>
								<input type="file" name="addPicFile01" id="addPicFile01"/>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>内容：</td>
							<td>
								<textarea rows="10" cols="50" style="width:300px;" id="tempData"><s:property value="addNewsDto.data"/></textarea>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span></span>英文版内容：</td>
							<td>
								<textarea rows="10" cols="50" style="width:300px;" id="tempEnData"><s:property value="addNewsDto.endata"/></textarea>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span></span>新闻链接1：</td>
							<td>
								<s:textfield name="addNewsDto.res01" id="title" cssStyle="width:500px;" maxlength="300" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
						<tr>
							<td class="td_tittle"><span></span>新闻链接2：</td>
							<td>
								<s:textfield name="addNewsDto.res02" id="title" cssStyle="width:500px;" maxlength="300" theme="simple"></s:textfield>
							</td>
						</tr>
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
