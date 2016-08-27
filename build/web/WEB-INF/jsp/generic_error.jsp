<%-- 
    Document   : generic_error
    Created on : 3/jul/2016, 12:46:57
    Author     : Diogo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>generic_error</title>
    </head>
    <body>
        
        <c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
        
    </body>
</html>
