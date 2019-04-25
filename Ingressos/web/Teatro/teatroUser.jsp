<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Ingressos</title>
    </head>
    <body> 
<center>
        <h1>Gerenciamento de Promoções</h1>
        <h2>
            <a href="cadastro">Adicione Nova Promoção</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2>Lista de Promoções</h2></caption>
            <tr>
                <th>Endereço</th>
                <th>Cnpj</th>
                <th>Nome</th>
                <th>Preço</th>
                <th>Dia</th>
                <th>Hora</th>
            </tr>
            <c:forEach var="promocao" items="${requestScope.listaPromocoes}">
                <tr>
                    <td><c:out value="${promocao.endereco}" /></td>
                    <td><c:out value="${promocao.cnpj}" /></td>
                    <td><c:out value="${promocao.nome}" /></td>
                    <td><c:out value="${promocao.dia}" /></td>
                    <td><c:out value="${promocao.hora}" /></td>
            </c:forEach>
        </table>
    </div>	
</body>
</html>