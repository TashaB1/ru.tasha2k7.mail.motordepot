<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="java.util.*, java.text.*, java.util.Base64"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Система Автобаза</title>
</head>
<body>
	<br />
	<br />
	<c:choose>
		<c:when test="${fn: contains(header['user-agent'], 'MSIE')}">
        You're using Internet Explorer.
    </c:when>
		<c:otherwise>
        You are using some browser other than IE.
    </c:otherwise>
	</c:choose>

	<br />
	<br />
	<p>Добро пожаловать!</p>
	<a href="/client">Client list</a>
	<br />
	<br />
	 <div id="main">
            <aside class="leftAside">
                <h2>Что нужно для регистрации</h2>
                <p>Что бы регистрация прошла успешно, заполните все поля и нажмите на
                кнопку "Зарегистрироваться"
                </p>
            </aside>
            <section>
                <article>
                    <h1>Регистрация</h1>
                    <div class="text-article">
                        <form method="POST" action="/authFilter/auth">
                      
                        <p>
                        <label for="email">E-Mail</label>
                        <input type="email" name="email" id="email"/>
                        </p>
                        <p>
                        <label for="password">Пароль</label>
                        <input type="password" name="password" id="password"/>
                        </p>
                        <p>
                            <button type="submit">Зарегистрироваться</button>
                        </p>
                        </form>
                    </div>
                </article>
            </section>
        </div>
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