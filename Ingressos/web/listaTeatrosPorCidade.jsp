<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
    </head>
    <body>
        <h1>Teatros por Cidade</h1>
            <table>
                <tr>
                    <th>Cidade </th>
                    <th>Cnpj </th>
                    <th>E-mail </th>
                    <th>Nome </th>
                </tr>
                <%
                    String p = request.getParameter("cidade");
                    List<Teatro> teatros = new ArrayList<>();
                    TeatroDAO teatroDAO = new TeatroDAO();
                    if (p != null){
                        teatros = teatroDAO.listarTodosTeatrosPorCidade(p);
                    }
                %>
                <c:forEach items="<%=teatros%>" var="teatro">
                    <tr>
                        <td><c:out value="${teatro.cidade}" /></td>
                        <td><c:out value="${teatro.cnpj}" /></td>
                        <td><c:out value="${teatro.email}" /></td>
                        <td><c:out value="${teatro.nome}" /></td>
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>
