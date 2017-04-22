<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta name="keywords" content="东升盈港" />
<meta name="description" content="东升盈港" />
<meta name="author" content="javascript:" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css<s:if test='#session.language == "en"'>/style_en.css</s:if><s:else>/style.css</s:else>" />
<script type="text/javascript">
   //显示图片
   function over(imgid,obj,imgbig)
   {
	//大图显示的最大尺寸  4比3的大小  400 324
	maxwidth=1200*0.5;
	maxheight=720*0.5;
	//显示
        obj.style.display="";
        var imgdd = document.getElementById(imgid);
        imgbig.src=imgdd.src;
//        imgbig.src=imgid.src;

        
        //1、宽和高都超过了，看谁超过的多，谁超的多就将谁设置为最大值，其余策略按照2、3
        //2、如果宽超过了并且高没有超，设置宽为最大值
        //3、如果宽没超过并且高超过了，设置高为最大值

        if(img.width>maxwidth&&img.height>maxheight)
        {
            pare=(img.width-maxwidth)-(img.height-maxheight);
            if(pare>=0)
                img.width=maxwidth;
            else
                img.height=maxheight;
        }
        else if(img.width>maxwidth&&img.height<=maxheight)
        {
            img.width=maxwidth;
        }
        else if(img.width<=maxwidth&&img.height>maxheight)
        {
            img.height=maxheight;
        }            
   }
   //隐藏图片
   function out()
   {
		document.getElementById('divImage').style.display="none";
   }
</script>
<script src="<%=request.getContextPath()%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/loopedslider.min.js" type="text/javascript"></script>
<title><s:text name="dsyg"/>-<s:text name="tchenicalinfo"/></title>
</head>
<body>
<jsp:include page="../head_web.jsp" flush="true" />
<%--显示大图标的区域--%>
<div id="divImage" style="display: none; left: 120px;top:50px; position: absolute; borderColor = "#eee"">
    <img id="imgbig" src="<%=request.getContextPath()%>/images/blank.png" alt="预览" />
</div>
<div class="main">
	<div id="contents">
		<!--////////// main start -->
		<h1 class="ttl w960"><s:text name="infodetailtitle"/></h1>
	    
		<div class="borderTop">
			<div id="blue-mat">
				<div class="w960">
					<p class="item"><s:text name="infodetailtip"/></p>
				</div>
			</div>
		</div>
		<!--////////// 説明部分 start -->
			<div class="content">
				<div class="fBox">

					<div class="caseBox">
						<h2>
							<img alt="title1" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex01-1.png" width="320" height="60"/>
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title2" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex02-1.png" width="320" height="60"/>
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title3" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex03-1.png" width="320" height="60"/>
						</h2>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex01.png"><img alt="what fex" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex01.png" width="324" height="181" /></a>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex02.png"><img alt="fluoro feature" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex02.png" width="324" height="181"></a>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex03.png"><img alt="abrasion resistance" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex03.png" width="324" height="181"></a>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title1" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex04-1.png" width="320" height="60">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title2" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex05-1.png" width="320" height="60">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title3" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex06-1.png" width="320" height="60">
						</h2>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex04.png"><img alt="combinative" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex04.png" width="324" height="181"></a>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex05.png"><img alt="Physical properties" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex05.png" width="324" height="181"></a>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex06.png"><img alt="Application1" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex06.png" width="324" height="181"></a>
					</div>

					<div class="caseBox">
						<h2>
							<img alt="title1" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex07-1.png" width="320" height="60">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title2" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex08-1.png" width="320" height="60">
						</h2>
					</div>
					<div class="caseBox">
						<h2>
							<img alt="title3" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>blank.png" width="320" height="60">
						</h2>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex07.png"><img alt="Application2" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex07.png" width="324" height="181"></a>
					</div>
					<div class="caseBox">
							<a href="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex08.png"><img alt="molecular structure" src="<%=request.getContextPath()%><s:if test='#session.language == "en"'>/images_en/</s:if><s:else>/images/</s:else>fex08.png" width="324" height="181"></a>
					</div>
					<div class="caseBox">
							<img alt="blank" src="<%=request.getContextPath()%>/images/blank.png" width="324" height="181">
					</div>
					<!--fBox -->
					<div class="clear"></div>
				</div>
			</div>
		<!--////////// 説明部分 end -->
		<!--contents -->
	</div>
</div>
<jsp:include page="../foot_web.jsp" flush="true" />
</body>
</html>
