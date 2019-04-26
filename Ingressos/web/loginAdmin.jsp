<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel = "stylesheet" type ="text/css" href = "estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
    </head>
    <body>
        <h1><f:message key="admin.login"/></h1>
        <form name="nome" method="post" action="Usuario/AdminUser/pageAdmin.jsp">
            <div><f:message key="user.name"/> <input type="text" name="nome"></div>
            <div><f:message key="user.password"/> <input type="password" name="senha"></div>
            <input type="submit" value="<f:message key="enter"/>">
        </form>
    </body>
</html>
</f:bundle>
