<%-- 
    Document   : criaranexo
    Created on : 2/jul/2016, 20:52:23
    Author     : Patricia Silva
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
	  	<title>ADD ANEXO</title>
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
                        <h2>Preencha o anexo:</h2>
                        
                        <p>* - perguntas obrigatórias</p>
                        <div class="table-responsive">
                            <form method="post" action="saveanexo" modelAttribute="anexoForm">
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
                        
                        <c:when test="${pergunta.nr_pergunta == '1'}">
                            <tr>
                                <td>${pergunta.nr_pergunta} - ${pergunta.pergunta}</td>
                                <td><input type="hidden" name="anexo[${status.index}].id" value="${pergunta.id}" readonly="true"/></td>
                                <td><input type="hidden" name="anexo[${status.index}].pergunta" value="${pergunta.pergunta}" readonly="true"/></td>
                                <td>
                                    <select name="anexo[${status.index}].resposta">
                                        <c:forEach items="${cadeiras}" var="cadeira" varStatus="status">
                                            <option value="${cadeira.nome}">${cadeira.nome}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </c:when>
                        <c:when test="${pergunta.nr_pergunta == '5'}">
                            <td>${pergunta.nr_pergunta} - ${pergunta.pergunta}</td>
                            <td><input type="hidden" name="anexo[${status.index}].id" value="${pergunta.id}" readonly="true"/></td>
                                <td><input type="hidden" name="anexo[${status.index}].pergunta" value="${pergunta.pergunta}" readonly="true"/></td>
                        </c:when>
                        
                        <c:when test="${pergunta.nr_pergunta == '10'}">
                            <td><input type="hidden" name="anexo[${status.index}].id" value="${pergunta.id}" readonly="true"/></td>
                            <td><input type="hidden" name="anexo[${status.index}].pergunta" value="${pergunta.pergunta}" readonly="true"/></td>
                                
                            <tr>
                                <td colspan="7">
                            <table id="myTable" class="table table-hover table-striped">
                                <th colspan="7"> * ${pergunta.nr_pergunta} - ${pergunta.pergunta} </th>
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
                                                <td><input name="pergunta10.nr_semana[${status.index}]" value="${pergunta}" required/></td>
                                                <td><input name="pergunta10.nr_sessao[${status.index}]" value="${anexoForm.pergunta10.nr_sessao[status.index]}" required/></td>
                                                <td><input name="pergunta10.conteudo_programatico[${status.index}]" value="${anexoForm.pergunta10.conteudo_programatico[status.index]}" required/></td>
                                                <td><input name="pergunta10.horas_de_trabalho[${status.index}].horas_contacto" value="${anexoForm.pergunta10.horas_de_trabalho[status.index].horas_contacto}" required/></td>
                                                <td><input name="pergunta10.horas_de_trabalho[${status.index}].horas_consolidacao" value="${anexoForm.pergunta10.horas_de_trabalho[status.index].horas_consolidacao}" required/></td>
                                                <td><input name="pergunta10.horas_de_trabalho[${status.index}].horas_outras_actividades" value="${anexoForm.pergunta10.horas_de_trabalho[status.index].horas_outras_actividades}" required/></td>
                                                <td><input name="pergunta10.descricao_outras_actividades[${status.index}]" value="${anexoForm.pergunta10.descricao_outras_actividades[status.index]}"/></td>

                                        </tr>
                                </c:forEach>
                            </table>
                                </td>
                            </tr>
                            <div>
                                <td colspan="7"><button class="btn btn-default" onclick="myCreateFunction(${anexoForm.pergunta10.nr_semana.size()});return false ">Inserir linha</button>
                                <button  class="btn btn-default" onclick="myDeleteFunction();return false">Remover linha</button>
                                </td>
                                <script>
                                    function myCreateFunction(i) {
                                        
                                        var table = document.getElementById("myTable");
                                        var row = table.insertRow(-1);
                                        var cell1 = row.insertCell(0);
                                        var cell2 = row.insertCell(1);
                                        var cell3 = row.insertCell(2);
                                        var cell4 = row.insertCell(3);
                                        var cell5 = row.insertCell(4);
                                        var cell6 = row.insertCell(5);
                                        var cell7 = row.insertCell(6);
                                        cell1.innerHTML = '<input name="pergunta10.nr_semana['+i+']" value="${pergunta}" required/>';
                                        cell2.innerHTML = '<input name="pergunta10.nr_sessao['+i+']" value="${anexoForm.pergunta10.nr_sessao[i]}" required/>';
                                        cell3.innerHTML = '<input name="pergunta10.conteudo_programatico['+i+']" value="${anexoForm.pergunta10.conteudo_programatico[i]}" required/>';
                                        cell4.innerHTML = '<input name="pergunta10.horas_de_trabalho['+i+'].horas_contacto" value="${anexoForm.pergunta10.horas_de_trabalho[i].horas_contacto}" required/>';
                                        cell5.innerHTML = '<input name="pergunta10.horas_de_trabalho['+i+'].horas_consolidacao" value="${anexoForm.pergunta10.horas_de_trabalho[i].horas_consolidacao}" required/>';
                                        cell6.innerHTML = '<input name="pergunta10.horas_de_trabalho['+i+'].horas_outras_actividades" value="${anexoForm.pergunta10.horas_de_trabalho[i].horas_outras_actividades}" required/>';
                                        cell7.innerHTML = '<input name="pergunta10.descricao_outras_actividades['+i+']" value="${anexoForm.pergunta10.descricao_outras_actividades[i]}"/>';
                                    }

                                    function myDeleteFunction() {
                                        document.getElementById("myTable").deleteRow(-1);
                                    }
                                </script>
                            </div>
                        </c:when>
                            
                        <c:otherwise>
                            
                            <tr>
                                <td>${pergunta.nr_pergunta} - ${pergunta.pergunta}</td>
                                <%--
                                passar o id no link como query string--%>
                                <td><input type="hidden" name="anexo[${status.index}].id" value="${pergunta.id}" readonly="true"/></td>
                                <td><input type="hidden" name="anexo[${status.index}].pergunta" value="${pergunta.pergunta}" readonly="true"/></td>
                                <td><input name="anexo[${status.index}].resposta" value="${pergunta.resposta}"></td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                        
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
