<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
    </head>
    <body>
        <h1>Teatros por Cidade</h1>
        <form name="nome" method="post" action="listaTeatros.jsp">
            <div>Cidade<input type="text" name="cidade"></div>
            <input type="submit" value="Entrar">
        </form>
        <a href="index.jsp">Voltar</a>
    </body>
</html>