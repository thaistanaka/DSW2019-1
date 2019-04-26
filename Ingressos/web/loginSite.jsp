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
        <h1><f:message key="site.login"/></h1>
        <form name="nome" method="post" action="pageSite.jsp">
            <div><f:message key="page.email"/> <input type="text" name="email"></div>
            <div><f:message key="user.password"/> <input type="password" name="senha"></div>
            <input type="submit" value="<f:message key="enter"/>">
        </form>
    </body>
</html>
</f:bundle>