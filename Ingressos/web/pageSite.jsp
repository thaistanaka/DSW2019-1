<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.SiteDAO"%>
<%@page import="br.ufscar.dc.dsw.model.ingressos.Site"%>
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
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Site t = new SiteDAO().getN(email, senha);
            String endereco = t.getEndereco();
        try{
            if (!(email.equals(t.getEmail()) && senha.equals(t.getSenha()))) {
                response.sendRedirect("loginSite.jsp");//trata se nao for igual
            }}catch(NullPointerException e){
                response.sendRedirect("loginSite.jsp");//trata se nao existir o nome
            }
        %>
        <p><f:message key="welcome"/> <%=email%>!</p>
        <a href="Site/siteUser.jsp?endereco=<%=endereco%>"><f:message key="sale.site"/></a><br/>        
    </body>
</html>

</f:bundle>