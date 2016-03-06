<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索引擎----网络蜘蛛</title>
<!--
<style >
	*{margin: 0;padding: 0;}
	body {background: blue;}
	#main{width: 960px;height: 480;margin: 200px auto;text-align: center;}
	h1 {color: #fff;}
	.textInput{height: 35px;width: 360px;color: green; font-size: 16px;}
	.butSubmit{height: 35px;width: 150px;}

</style>
-->
</head>
<body>
<div id="main">
<h1>搜索引擎------网络蜘蛛</h1>
<br/><br/>
<form action="getSource.jsp" method="post">
<input type="text" name="url" class="textInput"/>
<input type="submit" value="抓取源代码" class="butSubmit"/>
</form>
</div>
</body>
</html>