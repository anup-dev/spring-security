<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<html>
    <head>
    </head>
    <body>
    <h4>Login Success</h4>

    <form action="/logoutSucess" method="post">
                <input type="hidden"
                		name="${_csrf.parameterName}"
                		value="${_csrf.token}"/>
                <button type="submit">Log Out</button>
            </form>
    </body>
</html>