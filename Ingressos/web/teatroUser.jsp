<%@page import="br.ufscar.dc.dsw.dao.PromocaoDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Promocao"%>
<%@page import="java.util.List"%>
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
            <a href="promocao/cadastro">Adicione Nova Promoção</a>
        </h2>
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
            <% List<Promocao> promo = new PromocaoDAO().getAll();%>
            <c:forEach var="promo" items="<%=promo%>">
                <tr>
                    <td><c:out value="${promo.endereco}" /></td>
                    <td><c:out value="${promo.cnpj}" /></td>
                    <td><c:out value="${promo.nome}" /></td>
                    <td><c:out value="${promo.preco}" /></td>
                    <td><c:out value="${promo.dia}" /></td>
                    <td><c:out value="${promo.hora}" /></td>
                    <td>
                        <a href="edicao?cnpj=<c:out value='${promo.cnpj}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?cnpj=<c:out value='${promo.cnpj}' />" 
                           onclick="return confirm('Você tem certeza?');">
                            Remover
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>