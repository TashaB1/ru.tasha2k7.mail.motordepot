<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="java.util.*, java.text.*, java.util.Base64"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Система Автобаза</title>

<style type="text/css">
body {
	text-align: center;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>

</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<h1>Добро пожаловать!</h1>
	<a href="/admin">Admin</a>
	<a href="/dispatcher">Dispatcher</a>
	<a href="/driver">Driver</a>
	<a href="/client">Client</a>
	<br />
	<br />
	<a href="../../login1.jsp" target="_self">Вход</a>




	<br />
	<br />
	
	<br />
	<br />
	<br />
	<br /> This page has the following HTTP headers:
	<br />
	<ol>
		<%-- 'param' is an implicit object. It is a Map that maps a 'key'
           (the parameter name) to a 'value' --%>


		<c:forEach var="nextHeader" items="${header}">
			<li><c:out value="${nextHeader.key}" /> = <c:out
					value="${nextHeader.value}" />
		</c:forEach>


	</ol>

	<br />
	<br />


</body>
</html>