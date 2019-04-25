<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingressos</title>
    </head>
    
    <body>
        <%
                List<Teatro> teatros = new ArrayList<>();
                TeatroDAO teatroDAO = new TeatroDAO();
                request.setCharacterEncoding("UTF-8");
                if(request.getParameter("cidade") != null){
                    teatros = teatroDAO.listarTodosTeatrosPorCidade(request.getParameter("cidade"));
                    out.println("<center>");
                    out.println("<h2>Todos os teatros de" + request.getParameter("cidade") +"</h2>");
                    out.println("</center>");
                }
                else{
                    teatros = teatroDAO.getAll();
                    out.println("<center>");
                    out.println("<h2>Todos os teatros</h2>");
                    out.println("</center>");
                }
        %>
        <div align="center">
            <table border="1" cellpadding="3">
            <tr>
                <th>Cnpj</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Cidade</th>
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
        
    </body>
</html>