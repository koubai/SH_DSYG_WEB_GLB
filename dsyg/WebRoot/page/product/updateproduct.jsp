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
<title>东升盈港-产品更新</title>
<script type="text/javascript">
	function save() {
		if(checkData()) {
			if(confirm("确定更新吗？")) {
				document.mainform.action = '<c:url value="/product/updProductAction.action"></c:url>';
				document.mainform.submit();
			}
		}
	}
	
	function checkData() {
		var fieldcode = $("#fieldcode").val().trim();
		var rank = $("#rank").val().trim();
		var nameno = $("#nameno").val().trim();
		var typeno = $("#typeno").val().trim();
		var color1 = $("#color1").val().trim();
		//品牌
		var item08 = $("#item08").val().trim();
		//UL编号
		var item09 = $("#item09").val().trim();
		if(fieldcode == "") {
			alert("请选择产品类型！");
			$("#fieldcode").focus();
			return false;
		}
		if(rank == "") {
			alert("数据级别不能为空！");
			$("#rank").focus();
			return false;
		}
		if(!isNumber(rank)) {
			alert("数据级别必须是大于50小于90的数字！");
			$("#rank").focus();
			return false;
		}
		if(parseInt(rank) < 50 || parseInt(rank) > 90) {
			alert("数据级别必须是大于50小于90的数字！");
			$("#rank").focus();
			return false;
		}
		
		if(nameno == "") {
			alert("产品名称不能为空！");
			$("#nameno").focus();
			return false;
		}
		if(typeno == "") {
			alert("产品规格不能为空！");
			$("#typeno").focus();
			return false;
		}
		if(color1 == "") {
			alert("颜色不能为空！");
			$("#color1").focus();
			return false;
		}
		if(item08 == "") {
			alert("品牌不能为空！");
			$("#item08").focus();
			return false;
		}
		/*
		if(item09 == "") {
			alert("UL型号/编号不能为空！");
			$("#item09").focus();
			return false;
		}//*/
		
		//特征编辑值设定
		$("#item01").val("");
		$("#item02").val("");
		$("#item03").val("");
		$("#item04").val("");
		$("#item05").val("");
		$("#item06").val("");
		if(fieldcode == "01") {
			for(var i = 1; i <= 4; i++) {
				var name = "code01_item0" + i;
				//var v = $("input[name='" + name + "'][@checked]").val();
				var list = document.getElementsByName(name);
				for(var j = 0; j < list.length; j++) {
					if(list[j].checked) {
						var v = list[j].value;
						$("#" + "item0" + i).val(v);
						break;
					}
				}
			}
			if($("#item01").val() == "") {
				alert("请选择耐温！");
				$("#code01_01").focus();
				return false;
			}
			if($("#item02").val() == "") {
				alert("请选择耐压！");
				$("#code01_02").focus();
				return false;
			}
			if($("#item03").val() == "") {
				alert("请选择材质！");
				$("#code01_03").focus();
				return false;
			}
			//环保可以为空
			/*
			if($("#item04").val() == "") {
				alert("请选择环保！");
				$("#code01_04").focus();
				return false;
			}//*/
		} else if(fieldcode == "02") {
			for(var i = 1; i <= 6; i++) {
				var name = "code02_item0" + i;
				var list = document.getElementsByName(name);
				for(var j = 0; j < list.length; j++) {
					if(list[j].checked) {
						var v = list[j].value;
						$("#" + "item0" + i).val(v);
						break;
					}
				}
			}
			if($("#item01").val() == "") {
				alert("请选择耐温！");
				$("#code02_01").focus();
				return false;
			}
			if($("#item02").val() == "") {
				alert("请选择耐压！");
				$("#code02_02").focus();
				return false;
			}
			if($("#item03").val() == "") {
				alert("请选择绝缘！");
				$("#code02_03").focus();
				return false;
			}
			if($("#item04").val() == "") {
				alert("请选择收缩比！");
				$("#code02_04").focus();
				return false;
			}
			if($("#item05").val() == "") {
				alert("请选择材质！");
				$("#code02_05").focus();
				return false;
			}
			//环保可以为空
			/*
			if($("#item06").val() == "") {
				alert("请选择环保！");
				$("#code02_06").focus();
				return false;
			}//*/
		}
		
		//尺寸数据验证
		/*
		if($("#item10").val() == "") {
			alert("称呼尺寸不能为空！");
			$("#item10").focus();
			return false;
		}
		if($("#item11").val() == "") {
			alert("内径不能为空！");
			$("#item11").focus();
			return false;
		}
		if($("#item12").val() == "") {
			alert("壁厚不能为空！");
			$("#item12").focus();
			return false;
		}
		if($("#item13").val() == "") {
			alert("外径不能为空！");
			$("#item13").focus();
			return false;
		}
		if($("#item14").val() == "") {
			alert("长度不能为空！");
			$("#item14").focus();
			return false;
		}
		if($("#item15").val() == "") {
			alert("请选择尺寸编辑单位！");
			$("#item15").focus();
			return false;
		}
		//*/
		
		//图片验证
		var file01Name = $("#updPicFile01").val();
		var file02Name = $("#updPicFile02").val();
		var file03Name = $("#updPicFile03").val();
		var file04Name = $("#updPdfFile").val();
		//图片格式
		if(file01Name != "") {
			var n = file01Name.substring(file01Name.lastIndexOf("."), file01Name.length).toUpperCase();
			if(n != ".JPG" && n != ".GIF" && n != ".PNG") {
				alert("图片只支持JPG、GIF和PNG格式！");
				$("#updPicFile01").focus();
				return false;
			}
			$("#file01Name").val(file01Name);
		}
		//图2
		if(file02Name != "") {
			var n = file02Name.substring(file02Name.lastIndexOf("."), file02Name.length).toUpperCase();
			if(n != ".JPG" && n != ".GIF" && n != ".PNG") {
				alert("图片只支持JPG、GIF和PNG格式！");
				$("#updPicFile02").focus();
				return false;
			}
			$("#file02Name").val(file02Name);
		}
		//图3
		if(file03Name != "") {
			var n = file03Name.substring(file03Name.lastIndexOf("."), file03Name.length).toUpperCase();
			if(n != ".JPG" && n != ".GIF" && n != ".PNG") {
				alert("图片只支持JPG、GIF和PNG格式！");
				$("#updPicFile03").focus();
				return false;
			}
			$("#file03Name").val(file03Name);
		}
		//PDT文件验证
		if(file04Name != "") {
			var n = file04Name.substring(file04Name.lastIndexOf("."), file04Name.length).toUpperCase();
			if(n != ".PDF") {
				alert("请选择正确的PDF文件！");
				$("#updPdfFile").focus();
				return false;
			}
			$("#file04Name").val(file04Name);
		}
		return true;
	}
	
	function goBack() {
		document.mainform.action = '<c:url value="/product/queryManageProductAction.action"></c:url>';
		document.mainform.submit();
	}

	function changeFieldcode(obj) {
		//清空选择
		$("input[name^='code01_item0']").attr("checked", false);
		$("input[name^='code02_item0']").attr("checked", false);
		var v = obj.value;
		if(v == "01") {
			$("#fieldcode01").show();
			$("#fieldcode02").hide();
		} else if(v == "02") {
			$("#fieldcode02").show();
			$("#fieldcode01").hide();
		} else {
			$("#fieldcode01").hide();
			$("#fieldcode02").hide();
		}
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
					<div class="user_tittle">后台管理------产品更新
					</div>
				</div>
			</div>
			<div class="main_body">
				<s:form id="mainform" name="mainform" method="POST" enctype="multipart/form-data">
					<s:hidden name="updProduct01Dto.item01" id="item01"></s:hidden>
					<s:hidden name="updProduct01Dto.item02" id="item02"></s:hidden>
					<s:hidden name="updProduct01Dto.item03" id="item03"></s:hidden>
					<s:hidden name="updProduct01Dto.item04" id="item04"></s:hidden>
					<s:hidden name="updProduct01Dto.item05" id="item05"></s:hidden>
					<s:hidden name="updProduct01Dto.item06" id="item06"></s:hidden>
					<s:hidden name="updProduct01Dto.pic01" id="pic01"></s:hidden>
					<s:hidden name="updProduct01Dto.pic02" id="pic02"></s:hidden>
					<s:hidden name="updProduct01Dto.pic03" id="pic03"></s:hidden>
					<s:hidden name="file01Name" id="file01Name"></s:hidden>
					<s:hidden name="file02Name" id="file02Name"></s:hidden>
					<s:hidden name="file03Name" id="file03Name"></s:hidden>
					<s:hidden name="file04Name" id="file04Name"></s:hidden>
					<div style="position:absolute; margin-left: 400px; margin-top: 3px; text-align: center; color: red;">
						<s:actionmessage />
					</div>
					<table class="input_table" border="0" cellspacing="0" cellpadding="10">
						<tr>
							<td class="td_tittle"><span>*</span>产品类型：</td>
							<td>
								<select name="updProduct01Dto.fieldcode" id="fieldcode" style="width: 300px;" onchange="changeFieldcode(this);">
									<option value="">请选择</option>
									<s:iterator value="goodsList" id="goodsList" status="st1">
										<option value="<s:property value="code"/>" <s:if test="%{goodsList[#st1.index].code == updProduct01Dto.fieldcode}">selected</s:if>><s:property value="fieldname"/></option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>是否显示：</td>
							<td>
								<select name="updProduct01Dto.rank" id="rank" style="width:300px;">
									<s:if test='updProduct01Dto.rank == "50"'>
										<option value="50" selected="selected">显示</option>
										<option value="70">不显示</option>
									</s:if>
									<s:else>
										<option value="50">显示</option>
										<option value="70" selected="selected">不显示</option>
									</s:else>
								</select>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>产品名称：</td>
							<td><s:textfield name="updProduct01Dto.nameno" id="nameno" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield></td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>产品规格：</td>
							<td><s:textfield name="updProduct01Dto.typeno" id="typeno" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield></td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>颜色：</td>
							<td>
								<select name="updProduct01Dto.color1" id="color1" style="width:300px;">
									<s:iterator id="colorList" value="colorList" status="st1">
										<option value="<s:property value="code"/>" <s:if test='colorList[#st1.index].code == updProduct01Dto.color1'>selected</s:if>><s:property value="fieldname"/></option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>品牌：</td>
							<td><s:textfield name="updProduct01Dto.item08" id="item08" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield></td>
						<tr>
						<tr style="display: none;">
							<td class="td_tittle"><span>*</span>UL型号/编号：</td>
							<td><s:textfield name="updProduct01Dto.item09" id="item09" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield></td>
						<tr>
						<s:if test='updProduct01Dto.fieldcode == "01"'>
							<tr id="fieldcode01">
						</s:if>
						<s:else>
							<tr style="display: none;" id="fieldcode01">
						</s:else>
							<td class="td_tittle"><span>*</span>特征编辑：</td>
							<td>
								<s:iterator value="featureList01" id="featureList01" status="st1">
									<dl>
										<dt><s:property value="name"/>：</dt>
										<dd>
											<s:if test='%{featureList01[#st1.index].codename == "code01_item04" && #st1.index == 3}'>
												<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' checked value='' type="radio" /><label>无</label>
												<s:iterator value="dictList" id="dictList" status="st2">
													<s:if test='%{updProduct01Dto.fieldcode == "01" && featureList01[#st1.index].codename == "code01_item04" && #st1.index == 3}'>
														<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item04}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><label><s:property value="fieldname"/></label>
													</s:if>
													<s:else>
														<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' value='<s:property value="code"/>' type="radio" /><label><s:property value="fieldname"/></label>
													</s:else>
												</s:iterator>
											</s:if>
											<s:else>
												<s:iterator value="dictList" id="dictList" status="st2">
													<s:if test='%{updProduct01Dto.fieldcode == "01" && featureList01[#st1.index].codename == "code01_item01" && #st1.index == 0}'>
														<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item01}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><label><s:property value="fieldname"/></label>
													</s:if>
													<s:elseif test='%{updProduct01Dto.fieldcode == "01" && featureList01[#st1.index].codename == "code01_item02" && #st1.index == 1}'>
														<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item02}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><label><s:property value="fieldname"/></label>
													</s:elseif>
													<s:elseif test='%{updProduct01Dto.fieldcode == "01" && featureList01[#st1.index].codename == "code01_item03" && #st1.index == 2}'>
														<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item03}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><label><s:property value="fieldname"/></label>
													</s:elseif>
													<s:else>
														<input id="code01_0<s:property value="#st1.index + 1"/>" name='code01_item0<s:property value="#st1.index + 1"/>' value='<s:property value="code"/>' type="radio" /><label><s:property value="fieldname"/></label>
													</s:else>
												</s:iterator>
											</s:else>
										</dd>
									</dl>
								</s:iterator>
							</td>
						</tr>
						<s:if test='updProduct01Dto.fieldcode == "02"'>
							<tr id="fieldcode02">
						</s:if>
						<s:else>
							<tr style="display: none;" id="fieldcode02">
						</s:else>
							<td class="td_tittle"><span>*</span>特征编辑：</td>
							<td>
								<s:iterator value="featureList02" id="featureList02" status="st1">
									<dl>
										<dt><s:property value="name"/>：</dt>
										<dd>
											<s:if test='%{featureList02[#st1.index].codename == "code02_item06" && #st1.index == 5}'>
												<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' checked value='' type="radio" /><label>无</label>
												<s:iterator value="dictList" id="dictList" status="st2">
													<s:if test='%{updProduct01Dto.fieldcode == "02" && featureList02[#st1.index].codename == "code02_item06" && #st1.index == 5}'>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item06}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:if>
													<s:else>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:else>
												</s:iterator>
											</s:if>
											<s:else>
												<s:iterator value="dictList" id="dictList" status="st2">
													<s:if test='%{updProduct01Dto.fieldcode == "02" && featureList02[#st1.index].codename == "code02_item01" && #st1.index == 0}'>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item01}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:if>
													<s:elseif test='%{updProduct01Dto.fieldcode == "02" && featureList02[#st1.index].codename == "code02_item02" && #st1.index == 1}'>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item02}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:elseif>
													<s:elseif test='%{updProduct01Dto.fieldcode == "02" && featureList02[#st1.index].codename == "code02_item03" && #st1.index == 2}'>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item03}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:elseif>
													<s:elseif test='%{updProduct01Dto.fieldcode == "02" && featureList02[#st1.index].codename == "code02_item04" && #st1.index == 3}'>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item04}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:elseif>
													<s:elseif test='%{updProduct01Dto.fieldcode == "02" && featureList02[#st1.index].codename == "code02_item05" && #st1.index == 4}'>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' <s:if test='%{dictList[#st2.index].code == updProduct01Dto.item05}'>checked</s:if> value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:elseif>
													<s:else>
														<input id="code02_0<s:property value="#st1.index + 1"/>" name='code02_item0<s:property value="#st1.index + 1"/>' value='<s:property value="code"/>' type="radio" /><s:property value="fieldname"/>
													</s:else>
												</s:iterator>
											</s:else>
										</dd>
									</dl>
								</s:iterator>
							</td>
						</tr>
						<!--
						<tr>
							<td class="td_tittle"><span>*</span>尺寸编辑：</td>
							<td>
								<dl>
									<dt>称呼尺寸：</dt>
									<dd>
										<s:textfield name="updProduct01Dto.item10" id="item10" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>内径：</dt>
									<dd>
										<s:textfield name="updProduct01Dto.item11" id="item11" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>壁厚：</dt>
									<dd>
										<s:textfield name="updProduct01Dto.item12" id="item12" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>外径：</dt>
									<dd>
										<s:textfield name="updProduct01Dto.item13" id="item13" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>长度：</dt>
									<dd>
										<s:textfield name="updProduct01Dto.item14" id="item14" cssStyle="width:300px;" maxlength="32" theme="simple"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>单位：</dt>
									<dd>
										<select name="updProduct01Dto.item15" id="item15" style="width: 300px;">
											<s:iterator value="unitList" id="unitList" status="st2">
												<option value="<s:property value="code"/>" <s:if test="%{unitList[#st2.index].code == updProduct01Dto.item15}">selected</s:if>><s:property value="fieldname"/></option>
											</s:iterator>
										</select>
									</dd>
								</dl>
							</td>
						</tr>
						-->
						<tr>
							<td class="td_tittle"><span></span>图片上传：</td>
							<td>
								<input type="file" name="updPicFile01" id="updPicFile01"/><br />
								<s:if test='updProduct01Dto.pic01 != null && updProduct01Dto.pic01 != ""'>
									<img id="tmppic01" src="<s:property value="updProduct01Dto.imageurl"/><s:property value="updProduct01Dto.pic01"/>" alt="" /><br />
									<a id="tmpdel1" href="javascript:void(0);" onclick="delPic('tmppic01', 'tmpdel1', 'pic01')">删除</a>
								</s:if>
							</td>
						</tr>
						<tr>
							<td class="td_tittle">特性图片上传：</td>
							<td>
								<input type="file" name="updPicFile02" id="updPicFile02"/><br />
								<s:if test='updProduct01Dto.pic02 != null && updProduct01Dto.pic02 != ""'>
									<img id="tmppic02" src="<s:property value="updProduct01Dto.imageurl"/><s:property value="updProduct01Dto.pic02"/>" alt="" /><br />
									<a id="tmpdel2" href="javascript:void(0);" onclick="delPic('tmppic02', 'tmpdel2', 'pic02')">删除</a>
								</s:if>
							</td>
						</tr>
						<tr>
							<td class="td_tittle">尺寸图片上传：</td>
							<td>
								<input type="file" name="updPicFile03" id="updPicFile03"/><br />
								<s:if test='updProduct01Dto.pic03 != null && updProduct01Dto.pic03 != ""'>
									<img id="tmppic03" src="<s:property value="updProduct01Dto.imageurl"/><s:property value="updProduct01Dto.pic03"/>" alt="" /><br />
									<a id="tmpdel3" href="javascript:void(0);" onclick="delPic('tmppic03', 'tmpdel3', 'pic03')">删除</a>
								</s:if>
							</td>
						</tr>
						<tr>
							<td class="td_tittle"><span>*</span>PDF上传：</td>
							<td>
								<input type="file" name="updPdfFile" id="updPdfFile"/><br />
								<a target="_blank" href="<s:property value="updProduct01Dto.pdfurl"/><s:property value="updProduct01Dto.pdfpath"/>"><s:property value="updProduct01Dto.pdfpath"/></a>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn btn-blue" type="button" value="保存" onclick="save();"/>
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
