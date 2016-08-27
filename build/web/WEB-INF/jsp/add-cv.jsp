<%-- 
    Document   : add-cv
    Created on : 3/jul/2016, 12:13:20
    Author     : Diogo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD CV</title>
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
                            Criar CV
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <h2>Preencha o CV:</h2>
                        <div class="table-responsive">
                           <form method="post" action="savecv" modelAttribute="cvForm">
                            <table width="50%" class="table table-hover table-striped">
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
                                            <%--
                                            passar o id no link como query string--%>
                                            <td><input type="hidden" name="questionario[${status.index}].id" value="${pergunta.id}" readonly="true"/></td>
                                            <td><input type="hidden" name="questionario[${status.index}].pergunta" value="${pergunta.pergunta}" readonly="true"/></td>
                                            <td><input type="hidden" name="questionario[${status.index}].id_resposta" value="${pergunta.id_resposta}" readonly="true"/></td>
                                            <td><input name="questionario[${status.index}].resposta" value="${pergunta.resposta}"></td>
                                        </tr>
                                        
                                    </c:forEach>
                       
                               
                                </tbody>
                            </table>
                                 <button class="btn btn-primary" type="submit" style="float: right;">
                            Guardar <span class="glyphicon glyphicon-floppy-disk"></span>
                        </button>
                               </form>
                            
                           

                        </div>
                    </div>
                </div>

                <!-- /.row -->
                </div>
                <!-- /.row -->
               
                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>

    <!-- /#wrapper -->
   <%@include file="footer.jsp" %>
   </c:otherwise>
</c:choose>
    </body>
</html>
