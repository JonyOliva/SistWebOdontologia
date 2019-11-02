<%@page import="Entidad.iUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<%
	/*iUsuario user =null;
	if(session.getAttribute("usuarios") != null)
	{
		user = (iUsuario)session.getAttribute("usuario");
	}
	else
	{
		response.sendRedirect("index.jsp");
	}*/
	if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");

 %>
<title>Turnos</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuOdont.jsp"></jsp:include>
	<div class="container mt-3">
		<h5 class="titular">
			Turnos próximos
			</h1>
			
		<div>
			<table border=1>
				<tr>
					<th>DNI Paciente</th>
					<th>Odontologo</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>52636987</td>
					<td>****</td>
					<td>10/05/2019</td>
					<td>9:30hs</td>
					<td><a href="menuPaciente.jsp" class="btn btn-primary">Presente</a>
					<a href="menuPaciente.jsp" class="btn btn-danger">Ausente</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>