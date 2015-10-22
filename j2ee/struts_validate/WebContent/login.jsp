<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
	<form action="/struts_validate/account/login.action" method="post">
		姓名：<input name="username" type="text" />
		<br/>
		密码：<input name="password" type="password"/>
		<p>
		<input type="submit">提交</input>
	</form>
	<p>
${message}
<p>
<s:fielderror/>
<s:if test="#message==null">
没有错误
</s:if>
<s:else>
   有错误，请看详细信息
</s:else>

</body>
</html>