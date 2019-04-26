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
        <h1><f:message key="theater.city"/></h1>
        <form name="nome" method="post" action="listaTeatros.jsp">
            <div><f:message key="page.city"/><input type="text" name="cidade"></div>
            <input type="submit" value="<f:message key="enter"/>">
        </form>
        <a href="index.jsp"><f:message key="return"/></a>
    </body>
</html>
</f:bundle>