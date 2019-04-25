<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
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
        <p><f:message key="admin.welcome"/></p>
        <a href="Teatro/teatroCRUD.jsp"><f:message key="mod.theater.data"/></a><br/>
        <a href="Site/siteCRUD.jsp"><f:message key="mod.site.data"/></a><br/>        
    </body>
</html>

</f:bundle>