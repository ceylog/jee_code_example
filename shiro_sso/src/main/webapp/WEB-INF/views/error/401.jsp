<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>401 - 无权访问</title>
</head>

<body>
	<h2>404 - 没有权限访问该内容.</h2>
	<p><a href="<c:url value="/"/>">返回首页</a></p>
</body>
</html>