<!DOCTYPE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<html>
    <head>
    <script src="/resources/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/js/login.js"></script>
    </head>
    <body>
        <form id="submitForm" action="/loginUser" method="post">
            <label>UserName<input type="text" id="username" name="username"></label>
            <label>Password<input type="password" id="password" name="password"></label>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button id="submitForm" type="submit">Log In</button>
        </form>
    </body>
</html>