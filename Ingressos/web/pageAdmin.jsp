<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresso</title>
    </head>
    <body>
        <%
            String nome_certo = "admin";
            String senha_certo = "admin";
            
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            
            if (!((nome.equals(nome_certo)) && (senha.equals(senha_certo)))){
                response.sendRedirect("loginAdmin.jsp");
            }
        %>
        <p>Seja bem-vindo, admin!</p>
        <a href="Teatro/teatroCRUD.jsp">Modificar os dados de teatros</a><br/>
        <a href="Site/siteCRUD.jsp">Modificar os dados de sites de venda</a><br/>        
    </body>
</html>
