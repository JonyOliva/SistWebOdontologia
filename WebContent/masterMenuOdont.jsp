<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.iUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<nav class="navbar navbar-expand-lg navbar-light"
	style="background: #48C9B0;">
	<a class="navbar-brand" href="#">Menu Odontologo</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="ServletTurnos">Turnos
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ServletPacientes">Pacientes</a></li>
		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="#"><%
			if(session.getAttribute("usuario") != null)
			{
				iUsuario user = (iUsuario)session.getAttribute("usuario");
				if(user.isTipoUsuario() == false) out.println(((Odontologo)user).getNombre() +" "+ ((Odontologo)user).getApellido());
			}
			%>
			<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item">
			<form method="post" action="ServletUsuarios">
			<button style="background-color: #48C9B0;" type="submit" name="btnCerrarSesion"><img src="images/CerrarSesion3.png" alt="30" width="30" ></button>
			</form>
		</li>
	  </ul>
	</div>
</nav>
</html>