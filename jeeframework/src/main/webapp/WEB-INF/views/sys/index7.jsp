<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Hello World!</h2>


<shiro:authenticated>
<shiro:principal property="loginName"/><br>
	<a href="datautils.jsp">工具插件</a>


<a href="login.do?id=1">登录1</a>
<a href="login.do?id=2">登录2</a>
<a href="login.do?id=3">登录3</a>
	<shiro:hasAnyRoles name="r1">
	<a href="<%=request.getContextPath() %>/logout" class="admin_link">用户管理</a>
	</shiro:hasAnyRoles>
	<shiro:hasPermission name="test:*">
	<a href="<%=request.getContextPath() %>/logout" class="admin_link">用户管理1</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="test1:*">
	<a href="<%=request.getContextPath() %>/logout" class="admin_link">用户管理11</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="/admin/role/datautils">
	<a href="<%=request.getContextPath() %>/admin/role/datautils" class="admin_link">用户管理2</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="/admin/role/datautils2">
	<a href="<%=request.getContextPath() %>/admin/role/datautils2" class="admin_link">用户管理3</a>
	</shiro:hasPermission>
</shiro:authenticated>
<shiro:guest>
	<a href="<%=request.getContextPath() %>/login">登录系统</a>
</shiro:guest>
</body>
</html>
