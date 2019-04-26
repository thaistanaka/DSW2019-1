<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
    </head>
    <body>
        <h1><f:message key="index.name"/></h1>
        <hr>
        <p><f:message key="index.explanation"/></p>
        <a href="loginAdmin.jsp"><f:message key="acess.admin"/></a><br/>
        <a href="loginTeatro.jsp"><f:message key="acess.theater"/></a><br/>
        <a href="loginSite.jsp"><f:message key="acess.site"/></a><br/>
        <a href="teatrosPorCidade.jsp"><f:message key="theater.city"/></a><br/>
        <a href="listaTeatros.jsp"><f:message key="theaters"/></a><br/>
        <a href="promocoesDeTeatro.jsp"><f:message key="theater.sale"/></a><br/>
    </body>
</html>
</f:bundle>