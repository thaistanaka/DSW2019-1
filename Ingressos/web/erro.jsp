<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<link rel = "stylesheet" type ="text/css" href = "estilo.css">
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
    </head>
    <body>
        <h1><f:message key="error"/></h1>
        <f:message key="description"/> ${mensagem}
    </body>
</html>
</f:bundle>
