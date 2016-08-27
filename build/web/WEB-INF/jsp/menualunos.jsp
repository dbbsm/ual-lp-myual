<%-- 
    Document   : MenuProfessores
    Created on : 2/jul/2016, 16:59:49
    Author     : Patricia Silva
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
	  	<title>MENU ALUNO</title>
	  	<meta charset="utf-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/testecssbootstrap.css" />">
	  	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
               
                <script href="<c:url value="/resources/js/bootstrap.min.js"/>" />
	  	</script>
                
                 <link href="<c:url value="/resources/css/plugins/morris.css" />" rel="stylesheet">
                  <link href="<c:url value="/resources/css/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
	
    </head>
    <body>
        <c:choose>
            <c:when test="${empty sessionUser.username}">
                <p>You are not logged in. Please <a href="login">Login</a></p>
            </c:when>
            <c:otherwise>
       <div id="wrapper">
        <%@include file="menuincluiralunos.jsp" %>
        
        

        <!-- Navigation -->
        

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
               
                

            </div>
            <!-- /.container-fluid -->

        

    </div>
    <!-- /#page-wrapper -->
 
  </div>
  <!-- /#wrapper -->

<!-- /#wrapper -->
<%@include file="footer.jsp" %>
</c:otherwise>
</c:choose>
    </body>
</html>
