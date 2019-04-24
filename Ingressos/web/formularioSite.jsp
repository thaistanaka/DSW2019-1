<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Ingressos</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Sites</h1>
        <h2>
            <a href="new">Adicione Novo Site</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listaSite">Lista de Sites</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${site != null}">
            <form action="atualizacaoSite" method="post">
            </c:if>
            <c:if test="${site == null}">
                <form action="insercaoSite" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${site != null}">
                                Edição
                            </c:if>
                            <c:if test="${site == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${site != null}">
                        <input type="hidden" name="nome" value="<c:out value='${site.nome}' />" />
                    </c:if>            
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="text" name="email" size="45" required
                                   value="<c:out value='${site.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="number" name="senha" size="50" required
                                   value="<c:out value='${site.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Endereco: </th>
                        <td>
                            <input type="text" name="endereco" size="50" required
                                   value="<c:out value='${site.endereco}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Telefone: </th>
                        <td>
                            <input type="number" name="telefone" size="12" required
                                   value="<c:out value='${site.telefone}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salva" />
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
