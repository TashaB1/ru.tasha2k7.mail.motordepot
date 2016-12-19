<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<style type="text/css">
body {
	text-align: center;
}

table {
	width: 300px; /* Ширина таблицы */
	margin: auto; /* Выравниваем таблицу по центру окна  */
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
	text-align: center; /* Выравниваем текст по центру ячейки */
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

<body>
	<br />
	<br />
	<h1>Добро пожаловать!</h1>

	<div id="main">
		<br />
		<c:url var="login" value="/auth" />
		<br />
		<h2 id="banner">Login to Security Demo</h2>
		<form name="f" action="<c:url value='j_spring_security_check' />"
			method="POST">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type='text' name='j_username' /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password'></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit">&nbsp;<input
						name="reset" type="reset"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

