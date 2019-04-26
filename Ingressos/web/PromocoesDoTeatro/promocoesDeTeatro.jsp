<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel = "stylesheet" type ="text/css" href = "../estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="sale"/></title>
    </head>
    <body>
        <h1><f:message key="theater.sale"/></h1>
        <form name="nome" method="post" action="listaPromocoesDoTeatro.jsp">
            <div><f:message key="page.cnpj"/><input type="number" required name="cnpj"></div>
            <input type="submit" value="<f:message key="enter"/>">
            <a href="/Ingressos/index.jsp"><f:message key="return"/></a>
        </form>
        
    </body>
</html>
</f:bundle>
