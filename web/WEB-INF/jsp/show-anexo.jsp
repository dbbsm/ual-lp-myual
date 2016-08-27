<%-- 
    Document   : criaranexo
    Created on : 2/jul/2016, 20:52:23
    Author     : Patricia Silva
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
	  	<title>SHOW ANEXO</title>
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
                            Anexo B
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
                                 <c:forEach items="${anexoForm.anexo}" var="pergunta" varStatus="status">
                    <c:choose>
                        
                        <c:when test="${pergunta.nr_pergunta == '10'}">
                            <tr>
                                <td colspan="7">
                            <table  class="table table-hover table-striped">
                                <th colspan="7"> ${pergunta.nr_pergunta} - ${pergunta.pergunta} </th>
                                <tr>
                                    <td rowspan="2">Semana Nº </td>
                                    <td rowspan="2">Sessão Nº </td>
                                    <td rowspan="2">Conteúdo Programático</td>
                                    <td colspan="3">Horas de trabalho</td>
                                    <td rowspan="2">Descrição de outras actividades</td>
                                </tr>   
                                <tr>
                                    <td>Contacto</td>
                                    <td>Consolidação </td>
                                    <td>Outras actividades</td>
                                </tr>
                                
                                <c:forEach items="${anexoForm.pergunta10.nr_semana}" var="pergunta" varStatus="status">
                                        <tr>
                                            <td>${pergunta}</td>
                                            <td>${anexoForm.pergunta10.nr_sessao[status.index]}</td>
                                            <td>${anexoForm.pergunta10.conteudo_programatico[status.index]}</td>
                                            <td>${anexoForm.pergunta10.horas_de_trabalho[status.index].horas_contacto}</td>
                                            <td>${anexoForm.pergunta10.horas_de_trabalho[status.index].horas_consolidacao}</td>
                                            <td>${anexoForm.pergunta10.horas_de_trabalho[status.index].horas_outras_actividades}</td>
                                            <td>${anexoForm.pergunta10.descricao_outras_actividades[status.index]}</td>
                                            
                                           
                                        </tr>
                                </c:forEach>
                            </table>
                                </td>
                            </tr>
                        </c:when>
                            
                        <c:otherwise>
                            
                            <tr>
                                <td>${pergunta.nr_pergunta} - ${pergunta.pergunta}</td>
                                <td>${pergunta.resposta}
                            </tr>
                        </c:otherwise>
                    </c:choose>
                        
                </c:forEach>   



                                </tbody>
                            </table>
                                 
                            <div class="btn-group" style="float: right;">
                            <a href="copyanexo?id=${id}"><button class="btn btn-primary" type="button" > Copiar <span class="glyphicon glyphicon-duplicate"></span> </button></a>
                            <a href="removeanexo/${id}"><button class="btn btn-primary" type="button" > Apagar Anexo <span class="glyphicon glyphicon-trash"></span></button></a>
                            </div>                           

                        </div>
                    </div>
                </div>

                <!-- /.row -->
                
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
