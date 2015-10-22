<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>COUNT_BIZ</title>
</head>
<body>
	<h1>Action：Count的属性app_val的值为${app_val}</h1>
	<p>
	<h1>系统Application的缓存app_val的值为${applicationScope.app_val}</h1>
	<p>
	<h1>Action：Count的属性session_val的值为${session_val}</h1>
	<p>
	<h1>系统session的缓存的属性session_val的值为${sessionScope.session_val}</h1>
	<p>
	<h1>Action：Count的属性req_val的值为${req_val}</h1>
	<p>
	<h1>系统request的缓存的属性req_val的值为${requestScope.req_val}</h1>
	<p>
	<a href="/struts_login/biz1/app_counter.action">点击刷新app级别缓存值。</a>
	<p>
	<a href="/struts_login/biz1/session_counter.action">点击刷新session级别缓存值。</a>
	<p>
	<a href="/struts_login/biz1/req_counter.action">点击刷新req级别缓存值。</a>
</body>
</html> 