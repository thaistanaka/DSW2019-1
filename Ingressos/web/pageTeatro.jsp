<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.dao.TeatroDAO"%>
<link rel = "stylesheet" type ="text/css" href = "estilo.css">
<%@page import="br.ufscar.dc.dsw.model.ingressos.Teatro"%>
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

            Teatro t = new TeatroDAO().getN(email, senha);
            String nome = t.getNome();
            String cnpj = Integer.toString(t.getCnpj());
        try{
            if (!(email.equals(t.getEmail()) && senha.equals(t.getSenha()))) {
                response.sendRedirect("loginTeatro.jsp");//trata se nao for igual
            }}catch(NullPointerException e){
                response.sendRedirect("loginTeatro.jsp");//trata se nao existir o nome
            }
        %>
        <p><f:message key="welcome"/> <%=nome%>!</p>
        <a href="teatroUser.jsp?cnpj=<%=cnpj%>"><f:message key="sale.theater"/></a><br/>
    </body>
</html>
</f:bundle>
