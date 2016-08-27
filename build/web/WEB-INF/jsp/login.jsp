<%-- 
    Document   : login
    Created on : 18/mai/2016, 12:52:49
    Author     : Diogo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<head>
		<title>LOGIN</title>
	  	<meta charset="utf-8">
	  	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
	  	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
                <script href="<c:url value="/resources/js/bootstrap.min.js"/>" />
	  	</script>
                 <script src="js/jquery.min.js"></script>
                 
  </head>
	</head>

	<body>

		 <!--This is hidden/shown automatically after Durandal loads. -->
    <div class="container" style="display: none;">
      <div class="overlay loading">
        <i class="fa fa-spinner fa-5x fa-spin"></i><br/>
        <h1>Loading...</h1>
      </div>
    </div>
    
    <div class="container">
      <div class="overlay">
        <h1 class="header">
          <span class="fa-stack">
            <i class="fa fa-circle fa-stack-2x"></i>
            <i class="fa fa-fighter-jet fa-stack-1x fa-inverse rotate-45-left"></i>
          </span>
          My UAL
        </h1>
          
          
          <form class="form-signin" role="form" action="validate" method="POST">
          <h3 class="form-signin-heading">Entrar</h3>
          <c:if test="${not empty error.msg}">
              <div class="alert alert-danger">
                Erro: ${error.msg}
              </div>
          </c:if>
          <div class="input-group margin-bottom-sm">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input class="form-control" name="username" type="text" placeholder="Utilizador" required autofocus>
          </div>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input class="form-control" name="password" type="password" placeholder="Password" required>
          </div>
    
          <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        </form>
    
        <div class="footerlogin">
          <span class="pull-right">&copy; 2016 <a href="http://www.google.com" target="_blank" title="Company"></a> UAL</span>
        </div>
      </div>
    </div> <!-- /container -->
    <script src="js/bootstrap.min.js"></script>


		


	</body>



</html>
