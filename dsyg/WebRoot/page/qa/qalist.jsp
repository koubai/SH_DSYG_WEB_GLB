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
<title>东升盈港-咨询信息Q/A一览</title>
<script type="text/javascript">
	function del() {
		var id = getSelectedID();
		if(id == "") {
			alert("请选择一条记录！");
			return;
		} else {
			if(confirm("确定删除该记录吗？")) {
				document.mainform.action = '<c:url value="/qa/delQaAction.action"></c:url>' + "?delQaId=" + id;
				document.mainform.submit();
			}
		}
	}

	//检索
	function queryList() {
		document.mainform.action = '<c:url value="/qa/queryQaAction.action"></c:url>';
		document.mainform.submit();
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
	
	//翻页
	function changePage(pageNum) {
		document.getElementById("startIndex").value = pageNum;
		document.mainform.action = '<c:url value="/qa/turnQaAction.action"></c:url>';
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
					<div class="user_tittle">后台管理-----咨询信息Q/A一览
					</div>
				</div>
			</div>
			<jsp:include page="../head_manage.jsp" flush="true" />
			<div class="product_search main_body">
				<s:form id="mainform" name="mainform" method="POST">
					<s:hidden name="startIndex" id="startIndex"/>
					<div class="search1">
						<h3>Q/A标题
							<input class="keyword" name="queryQaDto.title" id="title" value="<s:property value="queryQaDto.title"/>" type="text" />
						</h3>
						<div class="line"></div>
					</div>
			  		<div class="search1" style="margin-top: 10px;">
						<h3>公司名称
							<input class="keyword" name="queryQaDto.company" id="company" value="<s:property value="queryQaDto.company"/>" type="text" />
							<input type="button" class="search_btn mgl5" value="检索" onclick="queryList();"/>
						</h3>
						<div class="line"></div>
					</div>
					<div class="tools">
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
							<td width="30"></td>
							<td width="50">序号</td>
							<td width="100">标题</td>
							<td width="140">内容</td>
							<td width="80">姓名</td>
							<td width="100">公司名称</td>
							<td width="120">地址</td>
							<td width="120">电话</td>
							<td width="120">传真</td>
							<td width="120">邮箱</td>
						</tr>
						<s:iterator id="qaList" value="qaList" status="st1">
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
									<div noWrap title="<s:property value="title"/>" style="width:90px;text-overflow:ellipsis;overflow:hidden">
										<s:property value="title"/>
									</div>
								</td>
								<td>
									<div noWrap title="<s:property value="data"/>" style="width:130px;text-overflow:ellipsis;overflow:hidden">
										<s:property value="data"/>
									</div>
								</td>
								<td><s:property value="fullname"/></td>
								<td>
									<div noWrap title="<s:property value="company"/>" style="width:90px;text-overflow:ellipsis;overflow:hidden">
										<s:property value="company"/>
									</div>
								</td>
								<td>
									<div noWrap title="<s:property value="address"/>" style="width:110px;text-overflow:ellipsis;overflow:hidden">
										<s:property value="address"/>
									</div>
								</td>
								<td><s:property value="tell" /></td>
								<td><s:property value="fax" /></td>
								<td><s:property value="email" /></td>
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
