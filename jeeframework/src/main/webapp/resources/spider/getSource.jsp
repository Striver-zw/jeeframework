<%@page import="org.zw.singleton.jeeframework.common.utils.spider.Spider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = request.getParameter("url");
	String pagerSource = Spider.getPageHtmlSource(url, "utf-8");
	pageContext.setAttribute("htmlsource", pagerSource);
	pageContext.setAttribute("url", url);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>源代码信息</title>
<!--
<style >
	body{background: blue;}
	#main{width: 90%;height:600px;margin: 200 auto;text-align: center;
	border: 1px solid red;}
	.t{width: 90%;height:600px;}
	h4 {color: #fff;}
	
</style>-->
</head>
<body>

<div id="main">
<h4>${url }该网址的源码</h4>
<textarea class="t">${htmlsource }</textarea>
</div>
</body>
</html>