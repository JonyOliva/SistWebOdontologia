<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDateTime" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css"> 
<title>Inicio</title>
</head>

<style>
	body{
	    margin: 0 auto 0 auto;
	    width: 100%;
	    background: #ebf9f6;
	}
	input{
	    border-radius: 4px;
	    text-align: center;
	}
	.box{
		background: white;
	    width:300px;
	    border-radius:6px;
	    margin: 3% auto 0 auto;
	    padding: 20px;
	    border: #9de2d4 1px solid; 
	}
</style>

<body>
	<%
		
	 %>
	<div class="container">
	
		<div>
			<form method="post" action="ServletUsuarios" class="box">
			<div class="subtitular mb-4 mt-0"> <h6> Iniciar sesión </h6> </div>
				<table>
				<tr>
					<td>
						Email:
					</td>
					<td>
						<input type="email" required name="txtEmail">
					</td>
				</tr>
				<tr>
					<td>
						Contraseña:
					</td>
					<td>
						<input type="password" required name="txtPassword">
					</td>
				</tr>
				</table>
				<br>
				<div style="text-align: center">
					<input type="submit" class="btn btnVerde" name="btnIniciarSesion" value="Iniciar Sesión" required name="btnIniciarSesion"></input><br>
				<div><%if(request.getAttribute("ErrorSesion")!= null)
							if(((boolean)request.getAttribute("ErrorSesion")) == true)
							{
								out.println("Los datos ingresados son incorrectos.");
							}
			 			%>
				 <div>
			 		<br><a href="#" onclick="abrirVentana()" title="VenEmergente">
			 		¿Olvidaste tu contraseña?</a>
			 	</div>
			</form>
			
		</div>
	
	</div>
	
<script type="text/javascript">

function abrirVentana() {
	var windowObjectReference;
  	windowObjectReference = window.open(
    "http://localhost:8080/SistWebOdontologia/RecuperarPass.jsp",
    "RecuperarContraseña",
     "menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes"
  );
}
</script>	
</body>
</html>