<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
    </head>
    <body>
        <h1>Todos os Teatros</h1>
        <table>
            <tr>
                <th>Cnpj</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Cidade</th>
            </tr>
           <c:forEach items="${requestScope.listaTeatros}" var="teatro">
                <tr>
                    <td>${teatro.cnpj}</td>
                    <td>${teatro.nome}</td>
                    <td>${teatro.email}</td>
                    <td>${teatro.cidade}</td>
                 </tr>
            </c:forEach>
        </table>
    </body>
</html>