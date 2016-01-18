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
<title>东升盈港-招聘信息一览</title>
<script type="text/javascript">
	$(document).ready(function(){
		var h = screen.availHeight; 
		$("#container").height(h - 60);
	});
	
	function add() {
		document.mainform.action = '<c:url value="/recruit/showAddRecruitAction.action"></c:url>';
		document.mainform.submit();
	}
	
	function upd() {
		var id = getSelectedID();
		if(id == "") {
			alert("请选择一条记录！");
			return;
		} else {
			document.mainform.action = '<c:url value="/recruit/showUpdRecruitAction.action"></c:url>' + "?updRecruitId=" +id;
			document.mainform.submit();
		}
	}
	
	function del() {
		var id = getSelectedID();
		if(id == "") {
			alert("请选择一条记录！");
			return;
		} else {
			if(confirm("确定删除该记录吗？")) {
				document.mainform.action = '<c:url value="/recruit/delRecruitAction.action"></c:url>' + "?delRecruitId=" + id;
				document.mainform.submit();
			}
		}
	}
	
	function getSelectedID() {
		var id = "";
		var list = document.getElementsByName("radioKey");
		for(var i = 0; i < list.length; i++) {
			if(list[i].checked) {
				id = list[i].value;
				break;
			}
		}
		return id;
	}
	
	function queryList() {
		document.mainform.action = '<c:url value="/recruit/queryRecruitAction.action"></c:url>';
		document.mainform.submit();
	}
	
	//翻页
	function changePage(pageNum) {
		document.getElementById("startIndex").value = pageNum;
		document.mainform.action = '<c:url value="/recruit/turnRecruitAction.action"></c:url>';
		document.mainform.submit();
	}

	//页跳转
	function turnPage(id) {
		var totalPage = "${page.totalPage}";
		var turnPage = $("#" +id).val();
		//判断是否输入页码
		if ('' != turnPage) {
			//判断页码是否是大于0的数字
			if(!iscInteger(turnPage)){
				alert("页码必须是大于0的整数！");
				$("#" +id).focus();
				return;
			}
			turnPage = parseInt(turnPage);
			if(turnPage < 1){
				alert("页码必须是大于0的整数！");
				$("#" +id).focus();
				return;
			}
			//判断页码大小是否正确
			if(turnPage > parseInt(totalPage)){
				alert("页码不能超过最大页数！");
				$("#" +id).focus();
				return;
			}
			//换页
			changePage(turnPage - 1);
		} else {
			alert("页码不能为空！");
			$("#" +id).focus();
			return;
		}	
	}
</script>
</head>
<body>
<div id="main" style="margin-top:2px;">
	<div  class="header_bg">
		<div class="content">
			<div class="user_bg">
				<div class="user">
					<div class="user_tittle">后台管理-----招聘信息一览
					</div>
				</div>
			</div>
			<jsp:include page="../head_manage.jsp" flush="true" />
			<div class="product_search main_body">
				<s:form id="mainform" name="mainform" method="POST">
					<s:hidden name="startIndex" id="startIndex"/>
			  		<div class="search1" style="margin-top: 10px;">
						<h3>　标题
							<input class="keyword" name="queryRecruitDto.title" id="queryTitle" value="<s:property value="queryRecruitDto.title"/>" type="text" />
							<input type="button" class="search_btn mgl5" value="检索" onclick="queryList();"/>
						</h3>
						<div class="line"></div>
					</div>
					<div class="tools">
						<s:if test='#session.user_rank >= 70'>
							<a href="javascript:void(0);" onclick="add();"><img src="<%=request.getContextPath()%>/images/add.png" />增加</a>
							<a href="javascript:void(0);" onclick="upd();"><img src="<%=request.getContextPath()%>/images/edit.png" />编辑</a>
						</s:if>
						<s:if test='#session.user_rank >= 90'>
							<a href="javascript:void(0);" onclick="del();"><img src="<%=request.getContextPath()%>/images/delete.png" />删除</a>
						</s:if>
					</div>
					<div class="page">
						<span>第${page.startIndex + 1}页 / 共${page.totalPage==0?1:page.totalPage}页 共${page.totalCount}条记录</span><span>
						跳转到第<input class="num" id="pagenum1" maxlength="6" type="text" />页</span><a href="javascript:void(0);" onclick="javascript:turnPage('pagenum1');">跳转</a>　　
						<a href="javascript:void(0);" onclick="changePage(0);">首页</a>
						<s:if test="%{page.startIndex <= 0}">
							<a href="javascript:void(0);">上一页</a>
						</s:if>
						<s:else>
							<a href="javascript:void(0);" onclick="changePage('${page.previousIndex}');">上一页</a>
						</s:else>
						<s:if test="%{page.nextIndex > page.totalPage - 1}">
							<a href="javascript:void(0);">下一页</a>
						</s:if>
						<s:else>
							<a href="javascript:void(0);" onclick="changePage('${page.nextIndex}');">下一页</a>
						</s:else>
						<a href="javascript:void(0);" onclick="changePage('${page.totalPage - 1}');">末页</a>
					</div>
					<table class="product_tab" width="100%" border="1" cellspacing="5" cellpadding="10">
						<tr class="tab_tittle">
							<td width="40"></td>
							<td width="60">序号</td>
							<td width="200">标题</td>
							<td width="100">招聘人数</td>
							<td width="120">创建人</td>
							<td width="140">创建日期</td>
							<td width="140">更新日期</td>
						</tr>
						<s:iterator id="recruitList" value="recruitList" status="st1">
						<s:if test="#st1.odd==true">
							<tr>
						</s:if>
						<s:else>
							<tr class="bg2">
						</s:else>
								<td>
									<input name="radioKey" type="radio" value="<s:property value="id"/>"/>
								</td>
								<td><s:property value="page.pageSize * (page.nextIndex - 1) + #st1.index + 1"/></td>
								<td>
									<div noWrap title="<s:property value="title"/>" style="width:190px;text-overflow:ellipsis;overflow:hidden">
										<s:property value="title"/>
									</div>
								</td>
								<td>
									<s:property value="persons"/>
								</td>
								<td><s:property value="createuid" /></td>
								<td><s:property value="createdate" /></td>
								<td><s:property value="updatedate" /></td>
							</tr>
						</s:iterator>
					</table>
					<div class="page">
						<span>第${page.startIndex + 1}页 / 共${page.totalPage==0?1:page.totalPage}页 共${page.totalCount}条记录</span><span>
						跳转到第<input class="num" id="pagenum2" maxlength="6" type="text" />页</span><a href="javascript:void(0);" onclick="javascript:turnPage('pagenum2');">跳转</a>　　
						<a href="javascript:void(0);" onclick="changePage(0);">首页</a>
						<s:if test="%{page.startIndex <= 0}">
							<a href="javascript:void(0);">上一页</a>
						</s:if>
						<s:else>
							<a href="javascript:void(0);" onclick="changePage('${page.previousIndex}');">上一页</a>
						</s:else>
						<s:if test="%{page.nextIndex > page.totalPage - 1}">
							<a href="javascript:void(0);">下一页</a>
						</s:if>
						<s:else>
							<a href="javascript:void(0);" onclick="changePage('${page.nextIndex}');">下一页</a>
						</s:else>
						<a href="javascript:void(0);" onclick="changePage('${page.totalPage - 1}');">末页</a>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
