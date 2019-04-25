<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.PromocaoDAO"%>
<%@page import= "br.ufscar.dc.dsw.model.ingressos.Promocao" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
    </head>
    <body>
        <h1>Promoções do Teatro</h1>
            <table>
                <tr>
                    <th>Endereço </th>
                    <th>Nome </th>
                    <th>Preço </th>
                    <th>Dia </th>
                    <th>Hora </th>
                </tr>
                <%
                    String p = request.getParameter("cnpj");
                    List<Promocao> promocoes = new ArrayList<>();
                    PromocaoDAO promocaoDAO = new PromocaoDAO();
                    if (p != null){
                        int v = Integer.parseInt(p);
                        promocoes = promocaoDAO.listarTodasPromocoesDeUmTeatro(v);
                    }
                %>
                    <c:forEach items="<%=promocoes%>" var="promocao">
                        <tr>
                            <td><c:out value="${promocao.endereco}" /></td>
                            <td><c:out value="${promocao.nome}" /></td>
                            <td><c:out value="${promocao.preco}" /></td>
                            <td><c:out value="${promocao.dia}" /></td>
                            <td><c:out value="${promocao.hora}" /></td>
                        </tr>
                    </c:forEach>
            </table>
    </body>
</html>
