<%-- 
    Document   : list-anexos
    Created on : 28/jun/2016, 12:43:19
    Author     : Diogo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>	  	
	  	<title>LIST ANEXOS</title>
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
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           Lista Anexos
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

                
                        <div class="table-responsive">
      
        <table width="50%" class="table table-hover table-striped">
                         <thead>
                                    <tr>
                                        <th>Unidade Curricular</th>
                                        <th>Ano</th>
                                        <th>Eliminar</th>
                                        <th>Copiar</th>
                                        <th>Visualizar</th>
                                        <th>Imprimir</th>
                                    </tr>
                                </thead>
                                 <tbody>
                <c:forEach items="${anexosForm}" var="anexo" varStatus="status">
                        <tr>
                            <td>${anexo.cadeira}</td>
                            <td>${anexo.ano}</td>
                            <td><a href="removeanexo/${anexo.id}"><button type="submit"> <span class="glyphicon glyphicon-trash"></span></a></td>
                            <td><a href="copyanexo?id=${anexo.id}"><button type="submit"><span class="glyphicon glyphicon-duplicate"></span> </button></a></td>
                        <td><a href="showanexo?id=${anexo.id}"> <button type="submit"><span class="glyphicon glyphicon glyphicon-eye-open"></span></button></a></td>
                        <td><a href="imprimiranexo?id=${anexo.id}"><button type="submit"> <span class="glyphicon glyphicon glyphicon glyphicon-print"></span> </button></a></td>
                                
                        </tr>
                </c:forEach>
         </tbody>

        </table>
                        </div>
         </div>
        <!-- /#page-wrapper -->

    </div>
        </div>
       <%@include file="footer.jsp" %>
       
       
       </c:otherwise>
</c:choose>
    </body>
</html>
