<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<link rel = "stylesheet" type ="text/css" href = "../estilo.css">
<link rel = "stylesheet" type ="text/css" href = "../../estilo.css">
<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <title><f:message key="page.title"/></title>
    </head>
    <body>
    <center>
        <h1><f:message key="manager.theater"/></h1>
        <h2>
            <a href="/Ingressos/teatro/cadastro"><f:message key="theater.add"/></a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="3">
            <caption><h2><f:message key="theater.list"/></h2></caption>
            <tr>
                <th><f:message key="page.email"/></th>
                <th><f:message key="page.password"/></th>
                <th><f:message key="page.cnpj"/></th>
                <th><f:message key="page.name"/></th>
                <th><f:message key="page.city"/></th>
                <th><f:message key="page.mod"/></th>
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
                        <a href="/Ingressos/teatro/edicao?cnpj=<c:out value='${teatro.cnpj}' />"><f:message key="edit"/></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Ingressos/teatro/remocao?cnpj=<c:out value='${teatro.cnpj}' />"
                           onclick="return confirm('<f:message key="confirm"/>');">
                            <f:message key="remove"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="/Ingressos/loginAdmin.jsp"><f:message key="return"/></a>
</body>
</html>
</f:bundle>
