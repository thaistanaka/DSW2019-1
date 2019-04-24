<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresso</title>
    </head>
    <body>
        <h1>Login do Teatro</h1>
        <form name="nome" method="post" action="pageTeatro.jsp">
            <div>Usuario <input type="text" name="nome"></div>
            <div>Senha <input type="password" name="senha"></div>
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
