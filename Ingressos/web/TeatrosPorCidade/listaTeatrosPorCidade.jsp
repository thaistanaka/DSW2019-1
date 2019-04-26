<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>
<link rel = "stylesheet" type ="text/css" href = "../estilo.css">
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
    </head>

    
        <%
                List<Teatro> teatros = new ArrayList<>();
                TeatroDAO teatroDAO = new TeatroDAO();
                request.setCharacterEncoding("UTF-8");
                teatros = teatroDAO.listarTodosTeatrosPorCidade(request.getParameter("cidade"));
        %>
        <center>
            <h2><f:message key="theatersd"/> <%=request.getParameter("cidade")%></h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="3">
            <tr>
                <th><f:message key="page.cnpj"/></th>
                <th><f:message key="page.name"/></th>
                <th><f:message key="page.email"/></th>
                <th><f:message key="page.city"/></th>
            </tr>
            <c:forEach items="<%=teatros%>" var="teatro">
                <tr>
                    <td>${teatro.cnpj}</td>
                    <td>${teatro.nome}</td>
                    <td>${teatro.email}</td>
                    <td>${teatro.cidade}</td>
                 </tr>
            </c:forEach>
            </table>
        </div>
        <a href="teatrosPorCidade.jsp"><f:message key="return"/></a>
    
</html>
</f:bundle>
