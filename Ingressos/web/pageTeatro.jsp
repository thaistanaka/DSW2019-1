<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresso</title>
    </head>
    <body>
        <%
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            Teatro t = new TeatroDAO().get(nome);
        try{
            if (!(nome.equals(t.getNome()) && senha.equals(t.getSenha()))) {
                response.sendRedirect("loginTeatro.jsp");//trata se nao for igual
            }}catch(NullPointerException e){
                response.sendRedirect("loginTeatro.jsp");//trata se nao existir o nome
            }
        %>
        <p>Seja bem-vindo, admin!</p>
        <a href="teatroCRUD.jsp">Modificar os dados de teatros</a><br/>
        <a href="siteCRUD.jsp">Modificar os dados de sites de venda</a><br/>        
    </body>
</html>
