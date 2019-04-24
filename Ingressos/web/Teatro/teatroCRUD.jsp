<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Ingresso</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento dos teatros</h1>
        <h2>
            <a href="cadastro">Adicione Novo Teatro</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2>Lista de Teatros</h2></caption>
            <tr>
                <th>E-mail</th>
                <th>Senha</th>
                <th>Cnpj</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Modificacoes</th>
            </tr>
            <% List<Teatro> tete = new TeatroDAO().getAll();%>
            <c:forEach var="teatro" items="<%=tete%>">
                <tr>
                    <td><c:out value="${teatro.email}" /></td>
                    <td><c:out value="${teatro.senha}" /></td>
                    <td><c:out value="${teatro.cnpj}" /></td>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.cidade}" /></td>
                    <td>
                        <a href="edicaoTeatro?id=<c:out value='${teatro.cnpj}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocaoTeatro?id=<c:out value='${teatro.cnpj}' />" 
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