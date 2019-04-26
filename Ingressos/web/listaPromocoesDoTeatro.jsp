<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.PromocaoDAO"%>
<%@page import= "br.ufscar.dc.dsw.model.ingressos.Promocao" %>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
    </head>
    <body>
    <center>
        <h1><f:message key="sale.in.theater"/></h1>
    </center>
    <%
            List<Promocao> promocoes = new PromocaoDAO().listarTodasPromocoesDeUmTeatro(request.getParameter("cnpj"));
        %>
            <div align="center">
            <table border="1" cellpadding="3">
                <tr>
                    <th><f:message key="page.adress"/></th>
                    <th><f:message key="page.cnpj"/></th>
                    <th><f:message key="page.name"/></th>
                    <th><f:message key="page.price"/></th>
                    <th><f:message key="page.day"/></th>
                    <th><f:message key="page.hour"/></th>
                </tr>
                
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
            <a href="index.jsp"><f:message key="return"/></a>
     
           
    </body>
</html>
</f:bundle>