<%-- 
    Document   : login
    Created on : Jan 24, 2014, 11:31:18 PM
    Author     : Lei
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="./resources/css/login.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    </head>
    <c:if test="${not empty param.error}">
        <font color="red">
        Login error. <br />
        Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </font>
    </c:if>
    <body onload='document.f.j_username.focus();'>
        <c:url value="/j_spring_security_check" var="loginUrl"></c:url>
        <h1>Custom login JSP page</h1>
        <div class="container">
            <form class="form-signin" name='f' role="form" action="${loginUrl}"
                  method='POST'>
                <h2 class="form-signin-heading">Please sign in</h2>
                <input type="text" name='j_username' class="form-control" placeholder="Email address" required autofocus>
                <input type="password" name='j_password' class="form-control" placeholder="Password" required>
                <label class="checkbox">
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
                <button class="btn btn-primary" type="submit">Sign in</button>
            </form>
        </div>
    </body>
</html>
