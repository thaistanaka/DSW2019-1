<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promoções</title>
    </head>
    <body>
        <h1>Promocoes por Teatro</h1>
        <form name="nome" method="post" action="buscaPorTeatro">
            <div>Cnpj<input type="text" name="cnpj"></div>
            <input type="submit" value="Entrar">
        </form>
        <a href="index.jsp">Voltar</a>
    </body>
</html>