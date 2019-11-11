<%@page import="NegocioImpl.GestionOdontologos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.Paciente" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
<title>Ficha odontologo</title>
</head>
<style>
<
style>body {
	margin: 0 auto 0 auto;
	width: 100%;
	background: #ebf9f6;
}

input {
	border-radius: 4px;
	text-align: center;
	margin: 0px 0px 10px 0px;
}

.box {
	background: white;
	width: 350px;
	border-radius: 6px;
	margin: 3% auto 0 auto;
	padding: 20px;
	border: #9de2d4 1px solid;
	text-align:center;
}
</style>

<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>
	
	<%!List<Odontologo> listaOdontologo;
	   GestionOdontologos go = new GestionOdontologos();%>
	<%listaOdontologo =go.getAll();
	  Paciente pac = (Paciente) request.getAttribute("paciente");%>
	
	<div class="container mt-3" >
		<div>
			<div>
				<h1 class="titular">
					Turno
					</h1>
			</div>
			
			<form class="box" action="ServletTurnos">
			<div class="box" style="width: 250px; float:rigth ">
			<%if(pac != null){ %>
					<table>
					<tr>
					<td>Nombre:<%= pac.getNombre().toString() %></td>
					</tr>
					<tr>
					<td>Apellido: <%= pac.getNombre().toString() %></td>
					</tr>
					<tr>
					<td>DNI: <%= pac.getNombre().toString() %></td>
					</tr>
					</table>
					<%} else{ %> El paciente no existe<%} %>
					</div>
				<table>
					<tr>
						<td>DNI paciente:</td>
						<td><input name ="txtDnipaciente" onmouseout="ServletTurnos" required type="number"></td>
					</tr>
					<br>
					<tr>
						<td>Odontologo:</td>
						<td>
						<select name="ddlOdontologo" onChange="Horarios();" style="margin-bottom: 10px; width: 100%;">
						
						<%for (Odontologo odon : listaOdontologo) { %>
							<option value="<%odon.getIDUsuario();%>"><%=odon.getApellido()%>, <%=odon.getNombre() %></option>
							<%} %>
							
						</select>
					</td>
					</tr>
					<tr>
						<td>Horario:</td>
						<td>
							<select name="ddlHorario" style="margin-bottom: 10px;">
							
								<option>09:30</option>
								<option>10:00</option>
								<option>10:30</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Fecha:</td>
						<td><input name="txtFecha" required type="date"></td>
					</tr>
				</table>
				<br>
				<div style="text-align: center">
					<input type="submit" name ="btnGuardar" value="Guardar"></input>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>