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
<title>东升盈港-新闻更新 </title>
<script type="text/javascript">
	function upd() {
		if(checkData()) {
			if(confirm("确定更新吗？")) {
				document.mainform.action = '<c:url value="/news/updNewsAction.action"></c:url>';
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
		var file01Name = $("#updPicFile01").val();
		if(file01Name != "") {
			var n = file01Name.substring(file01Name.lastIndexOf("."), file01Name.length).toUpperCase();
			if(n != ".JPG" && n != ".GIF" && n != ".PNG") {
				alert("图片只支持JPG、GIF和PNG格式！");
				$("#updPicFile01").focus();
				return false;
			}
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
					<div class="user_tittle">后台管理------新闻更新 
					</div>
				</div>
			</div>
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST" enctype="multipart/form-data">
					<s:hidden name="updNewsDto.newsdate" id="newsdate"></s:hidden>
					<s:hidden name="updNewsDto.data" id="data"></s:hidden>
					<s:hidden name="updNewsDto.endata" id="endata"></s:hidden>
					<s:hidden name="updNewsDto.pic01" id="pic01"></s:hidden>
					<s:hidden name="file01Name" id="file01Name"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<table class="input_table" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span>标题：</td>
							<td>
								<s:textfield name="updNewsDto.title" id="title" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>英文版标题：</td>
							<td>
								<s:textfield name="updNewsDto.entitle" id="entitle" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>作者：</td>
							<td>
								<s:textfield name="updNewsDto.author" id="author" cssStyle="width:300px;" maxlength="64" theme="simple"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>新闻日期：</td>
							<td>
								<div class="date_input">
									<input type="text" id="tmpnewsdate" disabled="disabled" value="<s:property value="updNewsDto.newsdate"/>"/>
									<a href="javascript:;" onclick="new Calendar().show(document.getElementById('tmpnewsdate'));"><img src="<%=request.getContextPath()%>/images/date.png" border="0" /></a>
								</div>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span></span>图片上传：</td>
							<td>
								<input type="file" name="updPicFile01" id="updPicFile01"/><br />
								<s:if test='updNewsDto.pic01 != null && updNewsDto.pic01 != ""'>
									<img id="tmppic01" src="<s:property value="updNewsDto.newsPicUrl"/><s:property value="updNewsDto.pic01"/>" alt="" /><br />
									<a id="tmpdel1" href="javascript:void(0);" onclick="delPic('tmppic01', 'tmpdel1', 'pic01')">删除</a>
								</s:if>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>内容：</td>
							<td>
								<textarea rows="10" cols="50" style="width:300px;" id="tempData"><s:property value="updNewsDto.data"/></textarea>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>英文版内容：</td>
							<td>
								<textarea rows="10" cols="50" style="width:300px;" id="tempEnData"><s:property value="updNewsDto.endata"/></textarea>
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
