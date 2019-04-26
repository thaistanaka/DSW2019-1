<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.SiteDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Site"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <title><f:message key="page.title"/></title>
    </head>
    <body>
    <center>
        <h1><f:message key="manager.site"/></h1> 
        <h2>
            <a href="site/cadastro"><f:message key="site.add"/></a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2><f:message key="site.list"/></h2></caption>
            <tr>
                <th><f:message key="page.email"/></th>
                <th><f:message key="page.password"/></th>
                <th><f:message key="page.adress"/></th>
                <th><f:message key="page.name"/></th>
                <th><f:message key="page.phone"/></th>
                <th><f:message key="page.mod"/></th>
            </tr>
            <% List<Site> sites = new SiteDAO().getAll();%>
            <c:forEach var="site" items="<%=sites%>">
                <tr>
                    <td><c:out value="${site.email}" /></td>
                    <td><c:out value="${site.senha}" /></td>
                    <td><c:out value="${site.endereco}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                    <td>
                        <a href="site/edicao?endereco=<c:out value='${site.endereco}' />"><f:message key="edit"/></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="site/remocao?endereco=<c:out value='${site.endereco}' />" 
                           onclick="return confirm('<f:message key="confirm"/>?');">
                            <f:message key="remove"/>
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
</f:bundle>