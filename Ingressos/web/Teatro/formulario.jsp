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
        <h1><f:message key="manager.theater"/></h1>
        <h2>
            <a href="lista"><f:message key="theater.list"/></a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${teatro != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${teatro == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${teatro != null}">
                                <f:message key="edition"/>
                            </c:if>
                            <c:if test="${teatro == null}">
                                <f:message key="register"/>
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${teatro != null}">
                        <input type="hidden" name="cnpj" value="<c:out value='${teatro.cnpj}' />" />
                    </c:if>            
                    <tr>
                        <th><f:message key="page.email"/>: </th>
                        <td>
                            <input type="text" name="email" size="45" required
                                   value="<c:out value='${teatro.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="user.password"/>: </th>
                        <td>
                            <input type="number" name="senha" size="50" required
                                   value="<c:out value='${teatro.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.cnpj"/>: </th>
                        <td>
                            <input type="number" name="cnpj" size="10" required
                                   value="<c:out value='${teatro.cnpj}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.name"/>: </th>
                        <td>
                            <input type="text" name="nome" size="50" required
                                   value="<c:out value='${teatro.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.city"/>: </th>
                        <td>
                            <input type="text" name="cidade" size="100" required 
                                   value="<c:out value='${teatro.cidade}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salvar" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>
    <c:if test="${!empty requestScope.mensagens}">
        <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
                </c:forEach>
        </ul>
    </c:if>
</body>
</html>
</f:bundle>
