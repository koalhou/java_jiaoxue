<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
	<form action="/spring_struts/account/login.action" method="post">
		姓名：<input name="username" type="text" />
		<br/>
		密码：<input name="password" type="password"/>
		<p>
		<input type="submit">提交</input>
	</form>
	<p>
	${message}
</body>
</html>