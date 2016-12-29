<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>users</title>
</head>
<body>
	注解handler
	<table>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.password}</td>
			</tr>
		</c:forEach>
		<tr>
				<td>共有：${info.total}条</td>
				<td>${info.nextPage}-1</td>
				<td>${info.pageSize}</td>
		</tr>
	</table>
</body>
</html>