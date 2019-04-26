<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel = "stylesheet" type ="text/css" href = "estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <title><f:message key="page.title"/></title>
    </head>
    <body>
<center>
        <h1><f:message key="manage.sale"/></h1>
        <h2>
            <a href="promocao/cadastro?cnpj=<%=request.getParameter("cnpj")%>"><f:message key="sale.add"/></a>
        </h2>
    </center>
</body>
</html>
</f:bundle>
