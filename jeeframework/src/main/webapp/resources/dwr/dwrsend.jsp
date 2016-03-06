 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送页面</title>
<script type="text/javascript" src="dwr/engine.js"></script>
        <script type="text/javascript" src="dwr/util.js"></script>
        <script type="text/javascript" src="dwr/interface/DwrTool.js"></script>
        <script type="text/javascript">
    
    function send(message) {
      DwrTool.sendMessageAuto("123", message);
    }
</script>
</head>
<body>


<br>
测试数据
<input type=button value="开始" onclick="send('你好你有一个新订单2')" />
</body>
</html>