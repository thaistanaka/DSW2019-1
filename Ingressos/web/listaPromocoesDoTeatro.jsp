<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.PromocaoDAO"%>
<%@page import= "br.ufscar.dc.dsw.model.ingressos.Promocao" %>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
    </head>
    <body>
    <center>
        <h1>Promoções Do Teatro</h1>
    </center>
            <div align="center">
            <table border="1" cellpadding="3">
                <tr>
                    <th>Endereço </th>
                    <th>Cnpj </th>
                    <th>Nome </th>
                    <th>Preço </th>
                    <th>Dia </th>
                    <th>Hora </th>
                </tr>
                <%
            List<Promocao> promocoes = new PromocaoDAO().listarTodasPromocoesDeUmTeatro(request.getParameter("cnpj"));
        %>
                    <c:forEach items="<%=promocoes%>" var="promocao">
                        <tr>
                            <td><c:out value="${promocao.endereco}" /></td>
                            <td><c:out value="${promocao.cnpj}" /></td>
                            <td><c:out value="${promocao.nome}" /></td>
                            <td><c:out value="${promocao.preco}" /></td>
                            <td><c:out value="${promocao.dia}" /></td>
                            <td><c:out value="${promocao.hora}" /></td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
           
    </body>
</html>
