<%-- 
    Document   : logout
    Created on : 6/jul/2016, 17:19:46
    Author     : Diogo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGOUT</title>
	  	
	  	<meta charset="utf-8">
	  	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/testecssbootstrap.css" />">
	  	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
                <script href="<c:url value="/resources/js/bootstrap.min.js"/>" />
	  	</script>
                 <script src="js/jquery.min.js"></script>
                 <link href="<c:url value="/resources/css/plugins/morris.css" />" rel="stylesheet">
                  <link href="<c:url value="/resources/css/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
       <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"> My Ual</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
            
                <li>
                        <a data-toggle="collapse" href="login">Login <span class="glyphicon glyphicon-log-in"></span></a>
                    </li>
            </ul>
            
        <!-- /.container -->
    </nav>


    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>Onde tudo se desconecta!</h1>
                        <h3>Obrigado pela visita!</h3>
                        <hr class="intro-divider">
                        
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
        


    

    
        <div class="container">
            <div class="row">
                <div class="footer">
                    
                    <p class="copyright text-muted small"> Universidade Autónoma de Lisboa 2016. </p>
                </div>
            </div>
        </div>
    

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>