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
            <% List<Promocao> promocao = new PromocaoDAO().listarTodasPromocoesDeUmSite(request.getParameter("endereco"));%>
            <c:forEach var="promocao" items="<%=promocao%>">
                <tr>
                    <td><c:out value="${promocao.endereco}" /></td>
                    <td><c:out value="${promocao.cnpj}" /></td>
                    <td><c:out value="${promocao.nome}" /></td>
                    <td><c:out value="${promocao.preco}" /></td>
                    <td><c:out value="${promocao.dia}" /></td>
                    <td><c:out value="${promocao.hora}" /></td>
            </c:forEach>
        </table>
    </div>	
</body>
</html>