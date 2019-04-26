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
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Teatro t = new TeatroDAO().getN(email, senha);
        try{
            if (!(email.equals(t.getEmail()) && senha.equals(t.getSenha()))) {
                response.sendRedirect("loginTeatro.jsp");//trata se nao for igual
            }}catch(NullPointerException e){
                response.sendRedirect("loginTeatro.jsp");//trata se nao existir o nome
            }
        %>
        <p>Seja bem-vindo, <%=email %>!</p>
        <a href="teatroUser.jsp">Adicionar promoções no seu teatro</a><br/>      
    </body>
</html>
