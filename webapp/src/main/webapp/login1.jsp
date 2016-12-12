<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>ggg</title>
</head>
<body>
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
                        <form method="POST" action="BasicAuthFilter">
                      
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
        
</body>
</html>