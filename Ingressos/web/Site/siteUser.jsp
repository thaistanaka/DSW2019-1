<%@page import="br.ufscar.dc.dsw.dao.PromocaoDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Promocao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <title><f:message key="page.title"/></title>
    </head>
    <body>
    <center>
        <h1><f:message key="manage.sale"/></h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2><f:message key="sale.list"/></h2></caption>
            <tr>
                <th><f:message key="page.adress"/></th>
                <th><f:message key="page.cnpj"/></th>
                <th><f:message key="page.name"/></th>
                <th><f:message key="page.price"/></th>
                <th><f:message key="page.day"/></th>
                <th><f:message key="page.hour"/></th>
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
</f:bundle>