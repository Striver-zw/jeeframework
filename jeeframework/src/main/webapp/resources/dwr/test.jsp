<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <script type='text/javascript' src='dwr/engine.js'> </script>
 <script type='text/javascript' src='dwr/util.js'> </script>
 <script type='text/javascript' src='dwr/interface/Demo.js'></script>

	<script>
	
	function onload(){	
			dwr.engine.setActiveReverseAjax(true);
	}
	
	function show(message){
		alert(message);
		document.getElementById('messageid').value=message;
	}
	
	</script>

</head>
<body onload="onload();">
 从服务端得到的消息:<br /> <input type="text" id="messageid" value="" size="80" />
</body>
</html>