<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Livraria Virtual</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Livros</h1>
        <h2>
            <a href="cadastro2">Adicione Novo Site</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista2">Lista de Sites</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2>Lista de Sites</h2></caption>
            <tr>
                <th>E-mail</th>
                <th>Senha</th>
                <th>Endereço</th>
                <th>Nome</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="site" items="${requestScope.listaSites}">
                <tr>
                    <td><c:out value="${site.email}" /></td>
                    <td><c:out value="${site.senha}" /></td>
                    <td><c:out value="${site.endereco}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                    <td>
                        <a href="edicao2?id=<c:out value='${site.endereco}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao2?id=<c:out value='${site.endereco}' />" 
                           onclick="return confirm('Você tem certeza?');">
                            Remover
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>