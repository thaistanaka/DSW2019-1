<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.SiteDAO"%>
<link rel = "stylesheet" type ="text/css" href = "../../estilo.css">
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
            String endereco = null;
            String nome = null;
            try{
            Site t = new SiteDAO().getN(email, senha);
            endereco = t.getEndereco();
            nome = t.getNome();
            if (!(email.equals(t.getEmail()) && senha.equals(t.getSenha()))) {
                response.sendRedirect("/Ingressos/loginSite.jsp");//trata se nao for igual
            }}catch(NullPointerException e){
                response.sendRedirect("/Ingressos/loginSite.jsp");//trata se nao existir o nome
            }
        %>
        <p><f:message key="welcome"/> <%=nome%>!</p>
        <a href="siteUser.jsp?endereco=<%=endereco%>"><f:message key="sale.site"/></a><br/>
        <a href="/Ingressos/loginSite.jsp"><f:message key="return"/></a>
    </body>
</html>
</f:bundle>
