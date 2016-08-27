<%-- 
    Document   : show-cv
    Created on : 6/jul/2016, 12:38:18
    Author     : Diogo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SHOW CV</title>
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
        <c:choose>
            <c:when test="${empty sessionUser.username}">
                <p>You are not logged in. Please <a href="login">Login</a></p>
            </c:when>
            <c:otherwise>
        <div id="wrapper">
        <%@include file="menuincluir.jsp" %>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            CV
                        </h1>

                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Pergunta</th>
                                        <th>Resposta</th>
                                    </tr>
                                </thead>
                                <tbody> 
                              
                                    <c:forEach items="${cvForm.questionario}" var="pergunta" varStatus="status">
                                        
                                        <tr>
                                            <td>${pergunta.nr_pergunta} - ${pergunta.pergunta}</td>
                                            <td>${pergunta.resposta}</td>
                                        </tr>
                                        
                                    </c:forEach>
                                                
                                                
                                </tbody>            
                                                   
                            </table>
                                
                                       
                              
                            
                        </div>
                    </div>
                </div>

                <!-- /.row -->
            </div>
            <!-- /.row -->

            <a href="editcv"><button class="btn btn-primary" type="submit" style="float: right;"> Editar </button></a>   
        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->


<!-- /#wrapper -->
<%@include file="footer.jsp" %>

</c:otherwise>
</c:choose>
    </body>
</html>
