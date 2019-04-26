<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <title><f:message key="sale"/></title>
    </head>
    <body>
    <center>
        <h1><f:message key="manage.sale"/></h1>
    </center>
    <div align="center">
        <form action="promocao/insercao" method="post">
                <table border="1" cellpadding="5">
                    <h2><f:message key="register"/></h2>
                    <tr>
                        <th><f:message key="page.adress"/></th>
                        <td>
                            <input type="text" name="endereco" size="45" required/>
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.cnpj"/></th>
                        <td>
                            <input type="number" name="cnpj" size="50" required/>
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.name"/></th>
                        <td>
                            <input type="text" name="nome" size="50" required />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.price"/></th>
                        <td>
                            <input type="text" name="preco" size="50" required />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.day"/></th>
                        <td>
                            <input type="text" name="dia" size="50" required
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><f:message key="page.hour"/></th>
                        <td>
                            <input type="number" name="hora" size="50" required
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