<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>拖拽上传</title>
<style type="text/css">
*{padding: 0px;margin: 0px;}
body {background: #394e48;font-size: 14px;font-family: "微软雅黑"}
#title{text-align: center;color: #fff;margin-top: 50px;}
.demo{width: 900px;margin: 50px auto;}
.drag{width: 100%;height: 100px;border: 3px dashed #fff;
		text-align: center;line-height: 100px;color: #280e06;
		font-size: 36px;font-weight: 700;
}
#preview div{
float: left;padding: 9px;
text-align: center;margin: 6px;
background: #f9f9f9;width: 195px;height: 95px;}
#preview img{width: 80px;height: 80px;}
</style>
</head>
<body>
	<h1 id="title">拖拽上传</h1>
	<div class="demo">
		<div class="drag" id="uploadList">拖拽到此处</div>
		<div id="preview"></div>
	</div>
	<script type="text/javascript" src="/jeeframework/static/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="/jeeframework/static/js/cooltheupload/cooltheupload.js"></script>
</body>
</html>